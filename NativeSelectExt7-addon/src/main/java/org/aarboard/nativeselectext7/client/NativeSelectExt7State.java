/*
 * Copyright 2018 a.schild.
 *
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
 */
package org.aarboard.nativeselectext7.client;

import com.vaadin.shared.ui.select.AbstractSelectState;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author a.schild
 */
public class NativeSelectExt7State extends AbstractSelectState {
    public List<String> disabledIndizes= new LinkedList<>();
}
