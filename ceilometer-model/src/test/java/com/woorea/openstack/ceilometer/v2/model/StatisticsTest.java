/*-
 * ============LICENSE_START=======================================================
 * ONAP - SO
 * ================================================================================
 * Copyright (C) 2018 Huawei Intellectual Property. All rights reserved.
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
package com.woorea.openstack.ceilometer.v2.model;

import org.junit.Test;

public class StatisticsTest {

    Statistics statistics = new Statistics();

    @Test
    public void getAvgTest() throws Exception {
        statistics.getAvg();
    }

    @Test
    public void getCountTest() throws Exception {
        statistics.getCount();
    }

    @Test
    public void getDurationTest() throws Exception {
        statistics.getDuration();
    }

    @Test
    public void getDurationStartTest() throws Exception {
        statistics.getDurationStart();
    }

    @Test
    public void getDurationEndTest() throws Exception {
        statistics.getDurationEnd();
    }

    @Test
    public void getMaxTest() throws Exception {
        statistics.getMax();
    }

    @Test
    public void getMinTest() throws Exception {
        statistics.getMin();
    }

    @Test
    public void getPeriodTest() throws Exception {
        statistics.getPeriod();
    }

    @Test
    public void getPeriodStartTest() throws Exception {
        statistics.getPeriodStart();
    }

    @Test
    public void getPeriodEndTest() throws Exception {
        statistics.getPeriodEnd();
    }

    @Test
    public void getSumTest() throws Exception {
        statistics.getSum();
    }

}