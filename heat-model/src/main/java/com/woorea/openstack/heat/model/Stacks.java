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

package com.woorea.openstack.heat.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stacks implements Iterable<Stack>, Serializable {
    @JsonProperty("stacks")
    private List<Stack> list;

    @JsonProperty("links")
    private List<Link> links;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public Iterator<Stack> iterator() {
        return list.iterator();
    }
}
