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

package org.opencord.aaa.impl;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.opencord.aaa.AaaMachineStatisticsService;
import org.opencord.aaa.AaaSupplicantMachineStats;

/**
 * Reset value of all aaa Machine Statistics counters to 0.
 */
//@Command(scope = "onos", name = "reset-aaa-machine-counters", description =
//"Reset value of all aaa Machine statistics counters to 0 ")
@Command(scope = "onos", name = "reset-aaa-machine-counters",
description = "Reset value of all aaa Machine statistics counters to 0 ")
public class AaaResetMachineCounterCommand extends AbstractShellCommand {

    @Argument(index = 0, name = "deviceId",
              description = "DeviceId of device from which packet is received",
              required = true, multiValued = false)
    private String deviceId;

    @Argument(index = 1, name = "portNumber",
             description = "Port no of device from which packet is received",
             required = true, multiValued = false)
    private String portNumber;

    @Override
    protected void execute() {


        String sessionId = deviceId + portNumber;
        StateMachine machineState = StateMachine.lookupStateMachineBySessionId(sessionId);
        AaaMachineStatisticsService aaaMachineStatsManager = AbstractShellCommand
                                   .get(AaaMachineStatisticsService.class);
        AaaSupplicantMachineStats aaaSupplicantMachineStats = aaaMachineStatsManager.getSupplicantStats(machineState);
        aaaMachineStatsManager.resetAllMachineCounters(aaaSupplicantMachineStats);

    }

}
