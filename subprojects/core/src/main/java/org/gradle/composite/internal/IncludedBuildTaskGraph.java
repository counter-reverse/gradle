/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.composite.internal;

import org.gradle.api.artifacts.component.BuildIdentifier;
import org.gradle.api.internal.TaskInternal;

import java.util.Collection;

public interface IncludedBuildTaskGraph {
    void addTask(BuildIdentifier requestingBuild, BuildIdentifier targetBuild, String taskPath);

    /**
     * Awaits completion of task execution, collecting any task failures into the given collection.
     */
    void awaitTaskCompletion(Collection<? super Throwable> taskFailures);

    IncludedBuildTaskResource.State getTaskState(BuildIdentifier targetBuild, String taskPath);

    TaskInternal getTask(BuildIdentifier targetBuild, String taskPath);
}
