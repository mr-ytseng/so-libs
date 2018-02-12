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

import org.junit.Test;

import static org.junit.Assert.*;

public class FlavorForCreateTest {

    private FlavorForCreate flavor = new FlavorForCreate();

    @Test
    public void getId() {
        flavor.getId();
    }

    @Test
    public void setId() {
        flavor.setId("123");
    }

    @Test
    public void getName() {
        flavor.getName();
    }

    @Test
    public void setName() {
        flavor.setName("123");
    }

    @Test
    public void getVcpus() {
        flavor.getVcpus();
    }

    @Test
    public void setVcpus() {
        flavor.setVcpus("123");
    }

    @Test
    public void getRam() {
        flavor.getRam();
    }

    @Test
    public void setRam() {
        flavor.setRam(123);
    }

    @Test
    public void getDisk() {
        flavor.getDisk();
    }

    @Test
    public void setDisk() {
        flavor.setDisk("123");
    }

    @Test
    public void getEphemeral() {
        flavor.getEphemeral();
    }

    @Test
    public void setEphemeral() {
        flavor.setEphemeral(123);
    }

    @Test
    public void getSwap() {
        flavor.getSwap();
    }

    @Test
    public void setSwap() {
        flavor.setSwap("123");
    }

    @Test
    public void getRxtxFactor() {
        flavor.getRxtxFactor();
    }

    @Test
    public void setRxtxFactor() {
        flavor.setRxtxFactor(123.0f);
    }
}