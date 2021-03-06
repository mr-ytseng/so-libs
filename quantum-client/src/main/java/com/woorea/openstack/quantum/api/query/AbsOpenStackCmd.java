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

package com.woorea.openstack.quantum.api.query;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.woorea.openstack.base.client.OpenStackRequest;

public class AbsOpenStackCmd<T> extends OpenStackRequest<T> {

    private T query;

    protected AbsOpenStackCmd(T query) {
        this.setQuery(query);
    }

    /**
     * @param query the query to set
     */
    public void setQuery(T query) {
        this.query = query;
    }

    /**
     * @return the query
     */
    public T getQuery() {
        return query;
    }

    private String getFieldValue(Field field, T target) {
        try {
            field.setAccessible(true);
            Object obj = field.get(target);
            if (obj == null)
                return null;
            return obj.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> getObjectParamMap(T target) {
        Map<String, String> resultMap = new HashMap<>();
        if (target == null)
            return resultMap;

        Field[] paramMap = target.getClass().getDeclaredFields();
        for (Field field : paramMap) {
            String resultName = field.getName();
            String value = getFieldValue(field, target);
            if (value != null) {
                JsonProperty prop = field.getAnnotation(JsonProperty.class);
                if (prop != null) {
                    resultMap.put(prop.value(), getFieldValue(field, target));
                } else {
                    resultMap.put(resultName, getFieldValue(field, target));
                }
            }
        }

        return resultMap;
    }

}
