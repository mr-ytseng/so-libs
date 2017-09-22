package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.Server.Addresses;
import com.woorea.openstack.nova.model.ServerAction.ChangePassword;
import com.woorea.openstack.nova.model.ServerAction.ConfirmResize;
import com.woorea.openstack.nova.model.ServerAction.ConsoleOutput;
import com.woorea.openstack.nova.model.ServerAction.CreateBackup;
import com.woorea.openstack.nova.model.ServerAction.CreateImage;
import com.woorea.openstack.nova.model.ServerAction.GetConsoleOutput;
import com.woorea.openstack.nova.model.ServerAction.GetVncConsole;
import com.woorea.openstack.nova.model.ServerAction.Lock;
import com.woorea.openstack.nova.model.ServerAction.Pause;
import com.woorea.openstack.nova.model.ServerAction.Reboot;
import com.woorea.openstack.nova.model.ServerAction.Rebuild;
import com.woorea.openstack.nova.model.ServerAction.Rescue;
import com.woorea.openstack.nova.model.ServerAction.Resize;
import com.woorea.openstack.nova.model.ServerAction.Resume;
import com.woorea.openstack.nova.model.ServerAction.RevertResize;
import com.woorea.openstack.nova.model.ServerAction.Start;
import com.woorea.openstack.nova.model.ServerAction.Stop;
import com.woorea.openstack.nova.model.ServerAction.Suspend;
import com.woorea.openstack.nova.model.ServerAction.Unlock;
import com.woorea.openstack.nova.model.ServerAction.Unpause;
import com.woorea.openstack.nova.model.ServerAction.Unrescue;
import com.woorea.openstack.nova.model.ServerAction.VncConsole;
import com.woorea.openstack.nova.model.ServerForCreate;
import com.woorea.openstack.nova.model.Servers;
import com.woorea.openstack.nova.model.VolumeAttachment;
import com.woorea.openstack.nova.model.VolumeAttachments;
import java.util.Map;

public class ServersResource {

    private final OpenStackClient client;
    private static final String SERVERS = "/servers/";
    private static final String ACTION = "/action";

    public ServersResource(OpenStackClient client) {
        this.client = client;
    }

    public List list(boolean detail) {
        return new List(detail);
    }

    public Boot boot(ServerForCreate server) {
        return new Boot(server);
    }

    public Show show(String id) {
        return new Show(id);
    }

    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    public CreateOrUpdateMetadata createOrUpdateMetadata(String id, Metadata metadata) {
        return new CreateOrUpdateMetadata(id, metadata);
    }

    public ReplaceMetadata replaceMetadata(String id, Metadata metadata) {
        return new ReplaceMetadata(id, metadata);
    }

    public DeleteMetadata deleteMetadata(String id, String key) {
        return new DeleteMetadata(id, key);
    }

    public Delete delete(String id) {
        return new Delete(id);
    }

    public class List extends OpenStackRequest<Servers> {

        public List(boolean detail) {
            super(client, HttpMethod.GET, detail ? "/servers/detail" : "/servers", null, Servers.class);
        }
    }

    public class Boot extends OpenStackRequest<Server> {

        private ServerForCreate server;

        public Boot(ServerForCreate server) {
            super(client, HttpMethod.POST, "/servers", Entity.json(server), Server.class);
            this.server = server;
        }
    }

    public class Show extends OpenStackRequest<Server> {

        public Show(String id) {
            super(client, HttpMethod.GET, new StringBuilder(SERVERS).append(id), null, Server.class);
        }
    }

    public class ShowMetadata extends OpenStackRequest<Metadata> {

        public ShowMetadata(String id) {
            super(client, HttpMethod.GET, new StringBuilder(SERVERS).append(id).append("/metadata"), null,
                Metadata.class);
        }
    }

    public class CreateOrUpdateMetadata extends OpenStackRequest<Metadata> {

        public CreateOrUpdateMetadata(String id, Metadata metadata) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append("/metadata"),
                Entity.json(metadata), Metadata.class);
        }
    }

    public class ReplaceMetadata extends OpenStackRequest<Metadata> {

        public ReplaceMetadata(String id, Metadata metadata) {
            super(client, HttpMethod.PUT, new StringBuilder(SERVERS).append(id).append("/metadata"),
                Entity.json(metadata), Metadata.class);
        }
    }

    public class DeleteMetadata extends OpenStackRequest<Void> {

        public DeleteMetadata(String id, String key) {
            super(client, HttpMethod.DELETE, new StringBuilder(SERVERS).append(id).append("/metadata/").append(key),
                null, Void.class);
        }
    }


    public class Delete extends OpenStackRequest<Void> {

        public Delete(String id) {
            super(client, HttpMethod.DELETE, new StringBuilder(SERVERS).append(id), null, Void.class);
        }
    }

    public class ShowServerAddresses extends OpenStackRequest<Addresses> {

        public ShowServerAddresses(String id) {
            super(client, HttpMethod.GET, new StringBuilder(SERVERS).append(id).append("/ips"), null,
                Addresses.class);
        }
    }

    public class UpdateServer extends OpenStackRequest<Server> {

        private Server server;

        public UpdateServer(String id, Server server) {
            super(client, HttpMethod.PUT, new StringBuilder(SERVERS).append(id), Entity.json(server), Server.class);
            this.server = server;
        }
    }

    public UpdateServer update(String serverId, String name, String accessIPv4, String accessIPv6) {
        Server server = new Server();
        //server.setName(name);
        //server.setAccessIPv4(accessIPv4);
        //server.setAccessIPv6(accessIPv6);
        return new UpdateServer(serverId, server);
    }

    public abstract class Action<T> extends OpenStackRequest<T> {

        public Action(String id, Entity<?> entity, Class<T> returnType) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION), entity,
                returnType);
        }
    }

    public class ChangePasswordAction extends Action<Server> {

        private ChangePassword action;

        public ChangePasswordAction(String id, ChangePassword action) {
            super(id, Entity.json(action), Server.class);
        }
    }

    public ChangePasswordAction changePassword(String serverId, String adminPass) {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setAdminPass(adminPass);
        return new ChangePasswordAction(serverId, changePassword);
    }

    public class RebootAction extends Action<Void> {

        private Reboot action;

        public RebootAction(String id, Reboot action) {
            super(id, Entity.json(action), Void.class);
        }
    }

    public RebootAction reboot(String serverId, String rebootType) {
        Reboot reboot = new Reboot();
        reboot.setType(rebootType);
        return new RebootAction(serverId, reboot);
    }

    public class RebuildAction extends Action<Server> {

        private Rebuild action;

        public RebuildAction(String id, Rebuild action) {
            super(id, Entity.json(action), Server.class);
        }
    }

    public RebuildAction rebuild(String serverId, Rebuild rebuild) {
        return new RebuildAction(serverId, rebuild);
    }

    public class ResizeAction extends Action<Server> {

        private Resize action;

        public ResizeAction(String id, Resize action) {
            super(id, Entity.json(action), Server.class);
        }
    }

    public ResizeAction resize(String serverId, String flavorId, String diskConfig) {
        Resize resize = new Resize();
        resize.setFlavorRef(flavorId);
        resize.setDiskConfig(diskConfig);
        return new ResizeAction(serverId, resize);
    }

    public class ConfirmResizeAction extends Action<Server> {

        public ConfirmResizeAction(String id) {
            super(id, Entity.json(new ConfirmResize()), Server.class);
        }
    }

    public ConfirmResizeAction confirmResize(String serverId) {
        return new ConfirmResizeAction(serverId);
    }

    public class RevertResizeAction extends Action<Server> {

        public RevertResizeAction(String id) {
            super(id, Entity.json(new RevertResize()), Server.class);
        }
    }

    public RevertResizeAction revertResize(String serverId) {
        return new RevertResizeAction(serverId);
    }

    public class CreateImageAction extends Action<Void> {

        public CreateImageAction(String id, CreateImage createImage) {
            super(id, Entity.json(createImage), Void.class);
        }
    }

    public CreateImageAction createImage(String serverId, String name, Map<String, String> metadata) {
        CreateImage createImage = new CreateImage();
        createImage.setName(name);
        createImage.setMetadata(metadata);
        return new CreateImageAction(serverId, createImage);
    }

    public class StartServer extends OpenStackRequest<Void> {

        private Start action;

        private String id;

        public StartServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Start()), Void.class);
        }
    }

    public class StopServer extends OpenStackRequest<Void> {

        private Stop action;

        private String id;

        public StopServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Stop()), Void.class);
        }
    }

    public StartServer start(String id) {
        return new StartServer(id);
    }

    public StopServer stop(String id) {
        return new StopServer(id);
    }

    public class GetVncConsoleServer extends OpenStackRequest<VncConsole> {

        private GetVncConsole action;

        private String id;

        public GetVncConsoleServer(String id, GetVncConsole action) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(action), VncConsole.class);
        }
    }

    public GetVncConsoleServer getVncConsole(String id, String type) {
        GetVncConsole action = new GetVncConsole(type);
        return new GetVncConsoleServer(id, action);
    }

    public class GetConsoleOutputServer extends OpenStackRequest<ConsoleOutput> {

        public GetConsoleOutputServer(String id, GetConsoleOutput action) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(action), ConsoleOutput.class);
        }
    }

    public GetConsoleOutputServer getConsoleOutput(String id, int length) {
        GetConsoleOutput action = new GetConsoleOutput(length);
        return new GetConsoleOutputServer(id, action);
    }

    public class PauseServer extends OpenStackRequest<Void> {

        public PauseServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Pause()), Void.class);
        }
    }

    public class UnpauseServer extends OpenStackRequest<Void> {

        public UnpauseServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Unpause()), Void.class);
        }
    }

    public class LockServer extends OpenStackRequest<Void> {

        private Lock action;

        private String id;

        public LockServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Lock()), Void.class);
        }
    }

    public class UnlockServer extends OpenStackRequest<Void> {

        private Unlock action;

        private String id;

        public UnlockServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Unlock()), Void.class);
        }
    }

    public class SuspendServer extends OpenStackRequest<Void> {

        public SuspendServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Suspend()), Void.class);
        }
    }

    public class ResumeServer extends OpenStackRequest<Void> {

        public ResumeServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Resume()), Void.class);
        }
    }

    public class CreateBackupServer extends OpenStackRequest<Void> {

        public CreateBackupServer(String id, CreateBackup action) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(action), Void.class);
        }
    }

    public PauseServer pause(String serverId) {
        return new PauseServer(serverId);
    }

    public UnpauseServer unpause(String serverId) {
        return new UnpauseServer(serverId);
    }

    public LockServer lock(String serverId) {
        return new LockServer(serverId);
    }

    public UnlockServer unlock(String serverId) {
        return new UnlockServer(serverId);
    }

    public SuspendServer suspend(String serverId) {
        return new SuspendServer(serverId);
    }

    public ResumeServer resume(String serverId) {
        return new ResumeServer(serverId);
    }

    public CreateBackupServer createBackup(String serverId, CreateBackup action) {
        return new CreateBackupServer(serverId, action);
    }

    public class RescueServer extends OpenStackRequest<Void> {

        public RescueServer(String id, Rescue action) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(action), Void.class);
        }
    }

    public class UnrescueServer extends OpenStackRequest<Void> {

        public UnrescueServer(String id) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(new Unrescue()), Void.class);
        }
    }

    public RescueServer rescue(String serverId, String adminPass) {
        Rescue action = new Rescue(adminPass);
        return new RescueServer(serverId, action);
    }

    public UnrescueServer unrescue(String serverId) {
        return new UnrescueServer(serverId);
    }

    public class AssociateFloatingIp extends OpenStackRequest<Void> {

        public AssociateFloatingIp(String id, com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(action), Void.class);
        }
    }

    public class DisassociateFloatingIp extends OpenStackRequest<Void> {

        public DisassociateFloatingIp(String id,
            com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
            super(client, HttpMethod.POST, new StringBuilder(SERVERS).append(id).append(ACTION),
                Entity.json(action), Void.class);
        }
    }

    public AssociateFloatingIp associateFloatingIp(String serverId, String floatingIpAddress) {
        com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp(
            floatingIpAddress);
        return new AssociateFloatingIp(serverId, action);
    }

    public DisassociateFloatingIp disassociateFloatingIp(String serverId, String floatingIpAddress) {
        com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp(
            floatingIpAddress);
        return new DisassociateFloatingIp(serverId, action);
    }

    public class AttachVolume extends OpenStackRequest<Void> {

        public AttachVolume(String serverId, final VolumeAttachment volumeAttachment) {
            super(client, HttpMethod.POST,
                new StringBuilder(SERVERS).append(serverId).append("/os-volume_attachments"),
                Entity.json(volumeAttachment), Void.class);
        }
    }

    public class DetachVolume extends OpenStackRequest<Void> {

        public DetachVolume(String serverId, String volumeId) {
            super(client, HttpMethod.DELETE,
                new StringBuilder(SERVERS).append(serverId).append("/os-volume_attachments/").append(volumeId),
                null, Void.class);
        }
    }

    public class ListVolumeAttachments extends OpenStackRequest<VolumeAttachments> {

        public ListVolumeAttachments(String serverId) {
            super(client, HttpMethod.GET,
                new StringBuilder(SERVERS).append(serverId).append("/os-volume_attachments"), null,
                VolumeAttachments.class);
        }
    }

    public class ShowVolumeAttachment extends OpenStackRequest<VolumeAttachment> {

        public ShowVolumeAttachment(String serverId, String volumeAttachmentId) {
            super(client, HttpMethod.GET,
                new StringBuilder(SERVERS).append(serverId).append("/os-volume_attachments/")
                    .append(volumeAttachmentId), null, VolumeAttachment.class);
        }
    }

    public AttachVolume attachVolume(String serverId, String volumeId, String device) {
        VolumeAttachment volumeAttachment = new VolumeAttachment();
        volumeAttachment.setVolumeId(volumeId);
        volumeAttachment.setDevice(device);
        return new AttachVolume(serverId, volumeAttachment);
    }

    public DetachVolume detachVolume(String serverId, String volumeId) {
        return new DetachVolume(serverId, volumeId);
    }

    public ListVolumeAttachments listVolumeAttachments(String serverId) {
        return new ListVolumeAttachments(serverId);
    }

    public ShowVolumeAttachment showVolumeAttachment(String serverId, String volumeAttachmentId) {
        return new ShowVolumeAttachment(serverId, volumeAttachmentId);
    }
}

