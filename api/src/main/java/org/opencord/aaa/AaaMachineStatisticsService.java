/*
 * Copyright 2018-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencord.aaa;

import org.onosproject.event.ListenerService;

/**
 * Service for interacting with authentication module.
 */
public interface AaaMachineStatisticsService
        extends ListenerService<AaaMachineStatisticsEvent, AaaMachineStatisticsEventListener> {
    /**
     * To get Supplicant machine stat.
     *
     * @param obj State Machine instance.
     * @return supplicant stats.
     */
    public AaaSupplicantMachineStats getSupplicantStats(Object obj);

    /**
     * Returns AaaMachineStatisticsDelegate object.
     *
     * @return AaaMachineStatisticsDelegate.
     */
    public AaaMachineStatisticsDelegate getMachineStatsDelegate();

    /**
     * Log the Machine stats.
     *
     * @param obj of AaaSupplicantMachineStats.
     */
    void logAaaSupplicantMachineStats(AaaSupplicantMachineStats obj);

    /**
     * Reset all the values of aaaMachine Stats.
     *
     * @param aaaMachineStatsManager of AaaSupplicantMachineStats.
     */
    public void resetAllMachineCounters(AaaSupplicantMachineStats aaaMachineStatsManager);

}
