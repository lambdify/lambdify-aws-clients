/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package lambdify.aws.client.dynamodb.model;

import javax.annotation.Generated;

/**
 * <br>
 * Determines the level of detail about provisioned throughput consumption that is returned in the response:
 * <br>
 * <ul>
 * <li>
 * <br>
 * <code>INDEXES</code> - The response includes the aggregate <code>ConsumedCapacity</code> for the operation, together
 * with <code>ConsumedCapacity</code> for each table and secondary index that was accessed.
 * <br>
 * <br>
 * Note that some operations, such as <code>GetItem</code> and <code>BatchGetItem</code>, do not access any indexes at
 * all. In these cases, specifying <code>INDEXES</code> will only return <code>ConsumedCapacity</code> information for
 * table(s).
 * <br>
 * </li>
 * <li>
 * <br>
 * <code>TOTAL</code> - The response includes only the aggregate <code>ConsumedCapacity</code> for the operation.
 * <br>
 * </li>
 * <li>
 * <br>
 * <code>NONE</code> - No <code>ConsumedCapacity</code> details are included in the response.
 * <br>
 * </li>
 * </ul>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public enum ReturnConsumedCapacity {

    INDEXES("INDEXES"),
    TOTAL("TOTAL"),
    NONE("NONE");

    private String value;

    private ReturnConsumedCapacity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value
     *        real value
     * @return ReturnConsumedCapacity corresponding to the value
     */
    public static ReturnConsumedCapacity fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (ReturnConsumedCapacity enumEntry : ReturnConsumedCapacity.values()) {
            if (enumEntry.toString().equals(value)) {
                return enumEntry;
            }
        }

        throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
    }
}
