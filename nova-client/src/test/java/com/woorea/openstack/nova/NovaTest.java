package com.woorea.openstack.nova;



import static org.junit.Assert.fail;

import org.junit.Test;
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

public class NovaTest {

    @Test
    public void test() {
        try
        {
            Nova nova = new Nova(null);    
        }
        catch(Exception ex)
        {
            fail("Exception while creating Nova");
        }
        
        
    }

}