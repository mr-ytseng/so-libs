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

package com.woorea.openstack.keystone.model;

import org.junit.Test;

public class LinkTest {

    Link link = new Link();

    @Test
    public void getRel() throws Exception {
        link.getRel();
    }

    @Test
    public void getHref() throws Exception {
        link.getHref();
    }

    @Test
    public void getType() throws Exception {
        link.getType();
    }

}