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

package com.woorea.openstack.quantum.model;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class NetworksTest {

    private static final String EOL = System.lineSeparator();

    private static final String JSON_FULL = "{" + EOL + "  \"networks\" : [ {" + EOL + "    \"name\" : \"name\"," + EOL
            + "    \"shared\" : true," + EOL + "    \"segments\" : [ {" + EOL
            + "      \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
            + "      \"provider:network_type\" : \"providernetworktype\"," + EOL
            + "      \"provider:segmentation_id\" : 92" + EOL + "    }, {" + EOL
            + "      \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
            + "      \"provider:network_type\" : \"providernetworktype\"," + EOL
            + "      \"provider:segmentation_id\" : 92" + EOL + "    } ]," + EOL + "    \"admin_state_up\" : false,"
            + EOL + "    \"tenant_id\" : \"tenantid\"," + EOL
            + "    \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
            + "    \"provider:network_type\" : \"providernetworktype\"," + EOL
            + "    \"provider:segmentation_id\" : 92," + EOL + "    \"router:external\" : true " + EOL + "  }, {" + EOL
            + "    \"name\" : \"name\"," + EOL + "    \"shared\" : true," + EOL + "    \"segments\" : [ {" + EOL
            + "      \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
            + "      \"provider:network_type\" : \"providernetworktype\"," + EOL
            + "      \"provider:segmentation_id\" : 92" + EOL + "    }, {" + EOL
            + "      \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
            + "      \"provider:network_type\" : \"providernetworktype\"," + EOL
            + "      \"provider:segmentation_id\" : 92" + EOL + "    } ]," + EOL + "    \"admin_state_up\" : false,"
            + EOL + "    \"tenant_id\" : \"tenantid\"," + EOL
            + "    \"provider:physical_network\" : \"providerphysicalnetwork\"," + EOL
            + "    \"provider:network_type\" : \"providernetworktype\"," + EOL
            + "    \"provider:segmentation_id\" : 92," + EOL + "    \"router:external\" : true" + EOL + "  } ]" + EOL
            + "}";

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL)
            .enable(SerializationFeature.INDENT_OUTPUT).enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Test
    public void testSerialization() throws Exception {
        System.out.println("CLASS: " + Networks.class.getName());
        System.out.println("TEST JSON: " + JSON_FULL);
        Networks networks = objectMapper.readValue(JSON_FULL, Networks.class);
        String json = objectMapper.writeValueAsString(networks);
        System.out.println("RE-SERIALIZED OBJECT: " + json);
        JSONAssert.assertEquals(JSON_FULL, json, JSONCompareMode.LENIENT);
    }

    @Test
    public void testMethods() throws Exception {
        Networks networks = objectMapper.readValue(JSON_FULL, Networks.class);
        networks.toString();

        List<Network> list = networks.getList();
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        networks.setList(list);

        int cnt = 0;
        for (@SuppressWarnings("unused")
        Network x : networks) {
            ++cnt;
        }
        Assert.assertEquals(2, cnt);
    }
}
