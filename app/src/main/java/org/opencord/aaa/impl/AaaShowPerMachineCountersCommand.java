/*
 * Copyright 2016-present Open Networking Foundation
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
 * CLI command for displaying all the AaaMachine Counters.
 */

@Command(scope = "onos", name = "show-aaa-machine-counters",
description = "Display current value of all aaa statistics counters")
public class AaaShowPerMachineCountersCommand extends AbstractShellCommand {

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
        AaaSupplicantMachineStats aaaSupplicantMachineStats = new AaaSupplicantMachineStats();
        StateMachine machineState = StateMachine.lookupStateMachineBySessionId(sessionId);
        if (machineState == null) {
            machineState = new StateMachine(sessionId);
        }
        AaaMachineStatisticsService aaaSupplicantManager =
                    AbstractShellCommand.get(AaaMachineStatisticsService.class);
        aaaSupplicantMachineStats = aaaSupplicantManager.getSupplicantStats(machineState);
        System.out.format("%30s %10d\n", "SessionDuration",
           aaaSupplicantMachineStats.getSessionDuration());
        System.out.format("%30s %10d\n", "TotalOctetRecieved",
           aaaSupplicantMachineStats.getTotalOctetRecieved());
        System.out.format("%30s %10d\n", "TotalFramesReceived",
          aaaSupplicantMachineStats.getTotalFramesReceived());
        System.out.format("%30s %10d\n", "TotalFramesSent",
          aaaSupplicantMachineStats.getTotalFramesSent());
        System.out.format("%30s %10d\n", "TotalOctetSent",
          aaaSupplicantMachineStats.getTotalOctetSent());
        System.out.format("%30s %10d\n", "TotalPacketsRecieved",
          aaaSupplicantMachineStats.getTotalPacketsRecieved());
        System.out.format("%30s %10d\n", "TotalPacketsSent",
          aaaSupplicantMachineStats.getTotalPacketsSent());

    }

}
