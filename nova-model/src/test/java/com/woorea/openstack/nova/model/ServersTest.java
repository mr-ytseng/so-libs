/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
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

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ServersTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL;

    static {
        // StringBuilder is used because extremely long concatenations
        // can cause compiler stack overflow
        StringBuilder sb = new StringBuilder();
        sb.append("{" + EOL);
        sb.append("  \"servers\" : [ {" + EOL);
        sb.append("    \"id\" : \"id\"," + EOL);
        sb.append("    \"name\" : \"name\"," + EOL);
        sb.append("    \"addresses\" : {" + EOL);
        sb.append("        \"addresses-k1\" : [ {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        }, {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        } ]," + EOL);
        sb.append("        \"addresses-k2\" : [ {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        }, {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        } ]" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"links\" : [ {" + EOL);
        sb.append("      \"rel\" : \"rel\"," + EOL);
        sb.append("      \"href\" : \"href\"," + EOL);
        sb.append("      \"type\" : \"type\"" + EOL);
        sb.append("    }, {" + EOL);
        sb.append("      \"rel\" : \"rel\"," + EOL);
        sb.append("      \"href\" : \"href\"," + EOL);
        sb.append("      \"type\" : \"type\"" + EOL);
        sb.append("    } ]," + EOL);
        sb.append("    \"image\" : {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"status\" : \"status\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"progress\" : 3," + EOL);
        sb.append("      \"minRam\" : 62," + EOL);
        sb.append("      \"minDisk\" : 69," + EOL);
        sb.append("      \"created\" : 1485172800000," + EOL);
        sb.append("      \"updated\" : 1486468800000," + EOL);
        sb.append("      \"metadata\" : {" + EOL);
        sb.append("        \"metadata-k1\" : \"metadata-v1\"," + EOL);
        sb.append("        \"metadata-k2\" : \"metadata-v2\"" + EOL);
        sb.append("      }," + EOL);
        sb.append("      \"server\" : {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"links\" : [ {" + EOL);
        sb.append("          \"rel\" : \"rel\"," + EOL);
        sb.append("          \"href\" : \"href\"," + EOL);
        sb.append("          \"type\" : \"type\"" + EOL);
        sb.append("        }, {" + EOL);
        sb.append("          \"rel\" : \"rel\"," + EOL);
        sb.append("          \"href\" : \"href\"," + EOL);
        sb.append("          \"type\" : \"type\"" + EOL);
        sb.append("        } ]" + EOL);
        sb.append("      }," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"OS-EXT-IMG-SIZE:size\" : 43" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"flavor\" : {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"vcpus\" : 79," + EOL);
        sb.append("      \"ram\" : 38," + EOL);
        sb.append("      \"disk\" : 45," + EOL);
        sb.append("      \"swap\" : \"swap\"," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"public\" : false," + EOL);
        sb.append("      \"OS-FLV-EXT-DATA:ephemeral\" : 65," + EOL);
        sb.append("      \"rxtx_factor\" : 11.0," + EOL);
        sb.append("      \"OS-FLV-DISABLED:disabled\" : true," + EOL);
        sb.append("      \"rxtx_quota\" : 42," + EOL);
        sb.append("      \"rxtx_cap\" : 96," + EOL);
        sb.append("      \"os-flavor-access:is_public\" : false" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"accessIPv4\" : \"accessipv4\"," + EOL);
        sb.append("    \"accessIPv6\" : \"accessipv6\"," + EOL);
        sb.append("    \"status\" : \"status\"," + EOL);
        sb.append("    \"progress\" : 3," + EOL);
        sb.append("    \"fault\" : {" + EOL);
        sb.append("      \"code\" : 29," + EOL);
        sb.append("      \"message\" : \"message\"," + EOL);
        sb.append("      \"details\" : \"details\"," + EOL);
        sb.append("      \"created\" : 1485172800000" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"hostId\" : \"hostid\"," + EOL);
        sb.append("    \"updated\" : \"updated\"," + EOL);
        sb.append("    \"created\" : \"created\"," + EOL);
        sb.append("    \"metadata\" : {" + EOL);
        sb.append("      \"metadata-k1\" : \"metadata-v1\"," + EOL);
        sb.append("      \"metadata-k2\" : \"metadata-v2\"" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"uuid\" : \"uuid\"," + EOL);
        sb.append("    \"adminPass\" : \"adminpass\"," + EOL);
        sb.append("    \"config_drive\" : \"configdrive\"," + EOL);
        sb.append("    \"tenant_id\" : \"tenantid\"," + EOL);
        sb.append("    \"user_id\" : \"userid\"," + EOL);
        sb.append("    \"key_name\" : \"keyname\"," + EOL);
        sb.append("    \"security_groups\" : [ {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"description\" : \"description\"," + EOL);
        sb.append("      \"rules\" : [ {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("    }, {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"description\" : \"description\"," + EOL);
        sb.append("      \"rules\" : [ {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("    } ]," + EOL);
        sb.append("    \"OS-EXT-STS:task_state\" : \"taskstate\"," + EOL);
        sb.append("    \"OS-EXT-STS:power_state\" : 1," + EOL);
        sb.append("    \"OS-EXT-STS:vm_state\" : \"vmstate\"," + EOL);
        sb.append("    \"OS-EXT-SRV-ATTR:host\" : \"host\"," + EOL);
        sb.append("    \"OS-EXT-SRV-ATTR:instance_name\" : \"instancename\"," + EOL);
        sb.append("    \"OS-EXT-SRV-ATTR:hypervisor_hostname\" : \"hypervisorhostname\"," + EOL);
        sb.append("    \"OS-DCF:diskConfig\" : \"diskconfig\"," + EOL);
        sb.append("    \"OS-EXT-AZ:availability_zone\" : \"availabilityzone\"," + EOL);
        sb.append("    \"OS-SRV-USG:launched_at\" : \"launchedat\"," + EOL);
        sb.append("    \"OS-SRV-USG:terminated_at\" : \"terminatedat\"," + EOL);
        sb.append(
                "    \"os-extended-volumes:volumes_attached\" : [  { \"id\":\"osextendedvolumesattached-v1\"},{\"id\": \"osextendedvolumesattached-v2\"} ]"
                        + EOL);
        sb.append("  }, {" + EOL);
        sb.append("    \"id\" : \"id\"," + EOL);
        sb.append("    \"name\" : \"name\"," + EOL);
        sb.append("    \"addresses\" : {" + EOL);
        sb.append("        \"addresses-k1\" : [ {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        }, {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        } ]," + EOL);
        sb.append("        \"addresses-k2\" : [ {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        }, {" + EOL);
        sb.append("          \"version\" : 4," + EOL);
        sb.append("          \"addr\" : \"addr\"," + EOL);
        sb.append("          \"OS-EXT-IPS-MAC:mac_addr\" : \"macaddr\"," + EOL);
        sb.append("          \"OS-EXT-IPS:type\" : \"type\"" + EOL);
        sb.append("        } ]" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"links\" : [ {" + EOL);
        sb.append("      \"rel\" : \"rel\"," + EOL);
        sb.append("      \"href\" : \"href\"," + EOL);
        sb.append("      \"type\" : \"type\"" + EOL);
        sb.append("    }, {" + EOL);
        sb.append("      \"rel\" : \"rel\"," + EOL);
        sb.append("      \"href\" : \"href\"," + EOL);
        sb.append("      \"type\" : \"type\"" + EOL);
        sb.append("    } ]," + EOL);
        sb.append("    \"image\" : {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"status\" : \"status\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"progress\" : 3," + EOL);
        sb.append("      \"minRam\" : 62," + EOL);
        sb.append("      \"minDisk\" : 69," + EOL);
        sb.append("      \"created\" : 1485172800000," + EOL);
        sb.append("      \"updated\" : 1486468800000," + EOL);
        sb.append("      \"metadata\" : {" + EOL);
        sb.append("        \"metadata-k1\" : \"metadata-v1\"," + EOL);
        sb.append("        \"metadata-k2\" : \"metadata-v2\"" + EOL);
        sb.append("      }," + EOL);
        sb.append("      \"server\" : {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"links\" : [ {" + EOL);
        sb.append("          \"rel\" : \"rel\"," + EOL);
        sb.append("          \"href\" : \"href\"," + EOL);
        sb.append("          \"type\" : \"type\"" + EOL);
        sb.append("        }, {" + EOL);
        sb.append("          \"rel\" : \"rel\"," + EOL);
        sb.append("          \"href\" : \"href\"," + EOL);
        sb.append("          \"type\" : \"type\"" + EOL);
        sb.append("        } ]" + EOL);
        sb.append("      }," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"OS-EXT-IMG-SIZE:size\" : 43" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"flavor\" : {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"vcpus\" : 79," + EOL);
        sb.append("      \"ram\" : 38," + EOL);
        sb.append("      \"disk\" : 45," + EOL);
        sb.append("      \"swap\" : \"swap\"," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"public\" : false," + EOL);
        sb.append("      \"OS-FLV-EXT-DATA:ephemeral\" : 65," + EOL);
        sb.append("      \"rxtx_factor\" : 11.0," + EOL);
        sb.append("      \"OS-FLV-DISABLED:disabled\" : true," + EOL);
        sb.append("      \"rxtx_quota\" : 42," + EOL);
        sb.append("      \"rxtx_cap\" : 96," + EOL);
        sb.append("      \"os-flavor-access:is_public\" : false" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"accessIPv4\" : \"accessipv4\"," + EOL);
        sb.append("    \"accessIPv6\" : \"accessipv6\"," + EOL);
        sb.append("    \"status\" : \"status\"," + EOL);
        sb.append("    \"progress\" : 3," + EOL);
        sb.append("    \"fault\" : {" + EOL);
        sb.append("      \"code\" : 29," + EOL);
        sb.append("      \"message\" : \"message\"," + EOL);
        sb.append("      \"details\" : \"details\"," + EOL);
        sb.append("      \"created\" : 1485172800000" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"hostId\" : \"hostid\"," + EOL);
        sb.append("    \"updated\" : \"updated\"," + EOL);
        sb.append("    \"created\" : \"created\"," + EOL);
        sb.append("    \"metadata\" : {" + EOL);
        sb.append("      \"metadata-k1\" : \"metadata-v1\"," + EOL);
        sb.append("      \"metadata-k2\" : \"metadata-v2\"" + EOL);
        sb.append("    }," + EOL);
        sb.append("    \"uuid\" : \"uuid\"," + EOL);
        sb.append("    \"adminPass\" : \"adminpass\"," + EOL);
        sb.append("    \"config_drive\" : \"configdrive\"," + EOL);
        sb.append("    \"tenant_id\" : \"tenantid\"," + EOL);
        sb.append("    \"user_id\" : \"userid\"," + EOL);
        sb.append("    \"key_name\" : \"keyname\"," + EOL);
        sb.append("    \"security_groups\" : [ {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"description\" : \"description\"," + EOL);
        sb.append("      \"rules\" : [ {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("    }, {" + EOL);
        sb.append("      \"id\" : \"id\"," + EOL);
        sb.append("      \"name\" : \"name\"," + EOL);
        sb.append("      \"description\" : \"description\"," + EOL);
        sb.append("      \"rules\" : [ {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"id\" : \"id\"," + EOL);
        sb.append("        \"name\" : \"name\"," + EOL);
        sb.append("        \"group\" : {" + EOL);
        sb.append("          \"name\" : \"name\"," + EOL);
        sb.append("          \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("        }," + EOL);
        sb.append("        \"parent_group_id\" : \"parentgroupid\"," + EOL);
        sb.append("        \"from_port\" : 7," + EOL);
        sb.append("        \"to_port\" : 98," + EOL);
        sb.append("        \"ip_protocol\" : \"ipprotocol\"," + EOL);
        sb.append("        \"ip_range\" : {" + EOL);
        sb.append("          \"cidr\" : \"cidr\"" + EOL);
        sb.append("        }" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"links\" : [ {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      }, {" + EOL);
        sb.append("        \"rel\" : \"rel\"," + EOL);
        sb.append("        \"href\" : \"href\"," + EOL);
        sb.append("        \"type\" : \"type\"" + EOL);
        sb.append("      } ]," + EOL);
        sb.append("      \"tenant_id\" : \"tenantid\"" + EOL);
        sb.append("    } ]," + EOL);
        sb.append("    \"OS-EXT-STS:task_state\" : \"taskstate\"," + EOL);
        sb.append("    \"OS-EXT-STS:power_state\" : 1," + EOL);
        sb.append("    \"OS-EXT-STS:vm_state\" : \"vmstate\"," + EOL);
        sb.append("    \"OS-EXT-SRV-ATTR:host\" : \"host\"," + EOL);
        sb.append("    \"OS-EXT-SRV-ATTR:instance_name\" : \"instancename\"," + EOL);
        sb.append("    \"OS-EXT-SRV-ATTR:hypervisor_hostname\" : \"hypervisorhostname\"," + EOL);
        sb.append("    \"OS-DCF:diskConfig\" : \"diskconfig\"," + EOL);
        sb.append("    \"OS-EXT-AZ:availability_zone\" : \"availabilityzone\"," + EOL);
        sb.append("    \"OS-SRV-USG:launched_at\" : \"launchedat\"," + EOL);
        sb.append("    \"OS-SRV-USG:terminated_at\" : \"terminatedat\"," + EOL);
        sb.append(
                "   \"os-extended-volumes:volumes_attached\" : [  { \"id\":\"osextendedvolumesattached-v1\"},{\"id\": \"osextendedvolumesattached-v2\"} ]"
                        + EOL);
        sb.append("  } ]" + EOL);
        sb.append("}");
        JSON_FULL = sb.toString();
    }

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Servers.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Servers servers = objectMapper.readValue(JSON_FULL, Servers.class);
        String json = objectMapper.writeValueAsString(servers);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Servers servers = objectMapper.readValue(JSON_FULL, Servers.class);
        servers.toString();

        List<Server> list = servers.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());

        int cnt = 0;
        for (@SuppressWarnings("unused")
        Server x : servers) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
