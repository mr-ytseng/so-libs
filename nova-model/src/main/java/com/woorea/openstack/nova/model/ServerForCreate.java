/*-
 * ============LICENSE_START=======================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("server")
public class ServerForCreate implements Serializable {

    public static final class SecurityGroup implements Serializable {

        private String name;

        public SecurityGroup() {}

        public SecurityGroup(String name) {
            this.name = name;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

    }

    private String name;

    private String adminPass;

    private String imageRef;

    private String flavorRef;

    private String accessIPv4;

    private String accessIPv6;

    private Integer min;

    private Integer max;

    private String diskConfig;

    @JsonProperty("key_name")
    private String keyName;

    private List<PersonalityFile> personality = new ArrayList<PersonalityFile>();

    private Map<String, String> metadata = new HashMap<String, String>();

    @JsonProperty("security_groups")
    private List<SecurityGroup> securityGroups;

    @JsonProperty("user_data")
    private String userData;

    @JsonProperty("availability_zone")
    private String availabilityZone;

    @JsonProperty("config_drive")
    private boolean configDrive;

    @JsonProperty("networks")
    private List<NetworkForCreate> networks = new ArrayList<NetworkForCreate>();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the adminPass
     */
    public String getAdminPass() {
        return adminPass;
    }

    /**
     * @param adminPass the adminPass to set
     */
    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    /**
     * @return the imageRef
     */
    public String getImageRef() {
        return imageRef;
    }

    /**
     * @param imageRef the imageRef to set
     */
    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    /**
     * @return the flavorRef
     */
    public String getFlavorRef() {
        return flavorRef;
    }

    /**
     * @param flavorRef the flavorRef to set
     */
    public void setFlavorRef(String flavorRef) {
        this.flavorRef = flavorRef;
    }

    /**
     * @return the accessIPv4
     */
    public String getAccessIPv4() {
        return accessIPv4;
    }

    /**
     * @param accessIPv4 the accessIPv4 to set
     */
    public void setAccessIPv4(String accessIPv4) {
        this.accessIPv4 = accessIPv4;
    }

    /**
     * @return the accessIPv6
     */
    public String getAccessIPv6() {
        return accessIPv6;
    }

    /**
     * @param accessIPv6 the accessIPv6 to set
     */
    public void setAccessIPv6(String accessIPv6) {
        this.accessIPv6 = accessIPv6;
    }

    /**
     * @return the min
     */
    public Integer getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * @return the diskConfig
     */
    public String getDiskConfig() {
        return diskConfig;
    }

    /**
     * @param diskConfig the diskConfig to set
     */
    public void setDiskConfig(String diskConfig) {
        this.diskConfig = diskConfig;
    }

    /**
     * @return the keyName
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * @param keyName the keyName to set
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * @return the personality
     */
    public List<PersonalityFile> getPersonality() {
        return personality;
    }

    /**
     * @param personality the personality to set
     */
    public void setPersonality(List<PersonalityFile> personality) {
        this.personality = personality;
    }

    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata the metadata to set
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * @return the securityGroups
     */
    public List<SecurityGroup> getSecurityGroups() {
        if (securityGroups == null) {
            securityGroups = new ArrayList<SecurityGroup>();
        }
        return securityGroups;
    }

    /**
     * @return the userData
     */
    public String getUserData() {
        return userData;
    }

    /**
     * @param userData the userData to set
     */
    public void setUserData(String userData) {
        this.userData = userData;
    }

    /**
     * @return the availabilityZone
     */
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * @param availabilityZone the availabilityZone to set
     */
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public boolean isConfigDrive() {
        return configDrive;
    }

    public void setConfigDrive(boolean configDrive) {
        this.configDrive = configDrive;
    }

    public List<NetworkForCreate> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkForCreate> networks) {
        this.networks = networks;
    }

    public void addNetworks(String id, String fixedIp) {
        NetworkForCreate net = new NetworkForCreate();
        net.setId(id);
        net.setFixedIp(fixedIp);
        this.networks.add(net);
    }

}
