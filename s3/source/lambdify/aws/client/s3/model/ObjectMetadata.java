/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package lambdify.aws.client.s3.model;

import java.io.Serializable;
import java.util.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents the object metadata that is stored with Amazon S3. This includes custom
 * user-supplied metadata, as well as the standard HTTP headers that Amazon S3
 * sends and receives (Content-Length, ETag, Content-MD5, etc.).
 *
 * <b>Note:</b> This is tiniest possible version from the Amazon's original ObjectMetadata
 * object. A lot of fields were omitted in order to keep the client small.
 */
@Data @Accessors(chain = true)
public class ObjectMetadata implements Serializable
{
    /**
     * All other (non user custom) headers such as Content-Length, Content-Type,
     * etc.
     */
    private Map<String, ?> metadata = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
}
