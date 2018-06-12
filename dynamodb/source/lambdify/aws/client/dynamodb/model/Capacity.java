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

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * <br>
 * Represents the amount of provisioned throughput capacity consumed on a table or an index.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/Capacity" target="_top">AWS API
 *      Documentation</a>
 */
@ToString @EqualsAndHashCode
public class Capacity implements Serializable, Cloneable {

    /**
     * <br>
     * The total number of capacity units consumed on a table or an index.
     * <br>
     */
    @JsonProperty("CapacityUnits")
    private Double capacityUnits;

    /**
     * <br>
     * The total number of capacity units consumed on a table or an index.
     * <br>
     *
     * @param capacityUnits
     *        The total number of capacity units consumed on a table or an index.
     */

    public void setCapacityUnits(Double capacityUnits) {
        this.capacityUnits = capacityUnits;
    }

    /**
     * <br>
     * The total number of capacity units consumed on a table or an index.
     * <br>
     *
     * @return The total number of capacity units consumed on a table or an index.
     */

    public Double getCapacityUnits() {
        return this.capacityUnits;
    }

    /**
     * <br>
     * The total number of capacity units consumed on a table or an index.
     * <br>
     *
     * @param capacityUnits
     *        The total number of capacity units consumed on a table or an index.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Capacity withCapacityUnits(Double capacityUnits) {
        setCapacityUnits(capacityUnits);
        return this;
    }
}
