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
 *
 * Portions copyright 2006-2009 James Murty. Please see LICENSE.txt
 * for applicable license terms and NOTICE.txt for applicable notices.
 */
package lambdify.aws.client.s3.model;
import java.io.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents an object stored in Amazon S3. This object contains
 * the data content
 * and the object metadata stored by Amazon S3, such as content type,
 * content length, etc.
 *
 * @see ObjectMetadata
 *
 * <b>Note:</b> This is tiniest possible version from the Amazon's original S3Object
 * object. A lot of fields were omitted in order to keep the client small.
 */
@Data @Accessors(chain = true)
public class S3Object implements Closeable, Serializable {

    private static final long serialVersionUID = 1L;

    /** The key under which this object is stored */
    private String key = null;

    /** The name of the bucket in which this object is contained */
    private String bucketName = null;

    /** The metadata stored by Amazon S3 for this object */
    private ObjectMetadata metadata = new ObjectMetadata();

    /** The stream containing the contents of this object from S3 */
    private transient InputStream objectContent;

    @Override
    public void close() throws IOException {
        objectContent.close();
    }
}
