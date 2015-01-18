/**
 *
 * Copyright © 2014 Florian Schmaus
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
package org.jivesoftware.smack.sm.predicates;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

public class AfterXStanzas implements PacketFilter {

    final int count;
    int currentCount;

    public AfterXStanzas(int count) {
        this.count = count;
        currentCount = 0;
    }

    @Override
    public synchronized boolean accept(Packet packet) {
        currentCount++;
        if (currentCount == count) {
            resetCounter();
            return true;
        }
        return false;
    }

    public synchronized void resetCounter() {
        currentCount = 0;
    }
}