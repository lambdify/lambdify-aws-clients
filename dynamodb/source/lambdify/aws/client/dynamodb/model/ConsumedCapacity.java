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
import com.fasterxml.jackson.annotation.*;
import lombok.*;

/**
 * <br>
 * The capacity units consumed by an operation. The data returned includes the total provisioned throughput consumed,
 * along with statistics for the table and any indexes involved in the operation. <code>ConsumedCapacity</code> is only
 * returned if the request asked for it. For more information, see <a
 * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html">Provisioned
 * Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/ConsumedCapacity" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class ConsumedCapacity implements Serializable, Cloneable {

    /**
     * <br>
     * The name of the table that was affected by the operation.
     * <br>
     */
    @JsonProperty("TableName")
    private String tableName;
    /**
     * <br>
     * The total number of capacity units consumed by the operation.
     * <br>
     */
    @JsonProperty("CapacityUnits")
    private Double capacityUnits;
    /**
     * <br>
     * The amount of throughput consumed on the table affected by the operation.
     * <br>
     */
    @JsonProperty("Table")
    private Capacity table;
    /**
     * <br>
     * The amount of throughput consumed on each local index affected by the operation.
     * <br>
     */
    @JsonProperty("LocalSecondaryIndexes")
    private java.util.Map<String, Capacity> localSecondaryIndexes;
    /**
     * <br>
     * The amount of throughput consumed on each global index affected by the operation.
     * <br>
     */
    @JsonProperty("GlobalSecondaryIndexes")
    private java.util.Map<String, Capacity> globalSecondaryIndexes;

    /**
     * <br>
     * The name of the table that was affected by the operation.
     * <br>
     *
     * @param tableName
     *        The name of the table that was affected by the operation.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * <br>
     * The name of the table that was affected by the operation.
     * <br>
     *
     * @return The name of the table that was affected by the operation.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * <br>
     * The name of the table that was affected by the operation.
     * <br>
     *
     * @param tableName
     *        The name of the table that was affected by the operation.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * <br>
     * The total number of capacity units consumed by the operation.
     * <br>
     *
     * @param capacityUnits
     *        The total number of capacity units consumed by the operation.
     */

    public void setCapacityUnits(Double capacityUnits) {
        this.capacityUnits = capacityUnits;
    }

    /**
     * <br>
     * The total number of capacity units consumed by the operation.
     * <br>
     *
     * @return The total number of capacity units consumed by the operation.
     */

    public Double getCapacityUnits() {
        return this.capacityUnits;
    }

    /**
     * <br>
     * The total number of capacity units consumed by the operation.
     * <br>
     *
     * @param capacityUnits
     *        The total number of capacity units consumed by the operation.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity withCapacityUnits(Double capacityUnits) {
        setCapacityUnits(capacityUnits);
        return this;
    }

    /**
     * <br>
     * The amount of throughput consumed on the table affected by the operation.
     * <br>
     *
     * @param table
     *        The amount of throughput consumed on the table affected by the operation.
     */

    public void setTable(Capacity table) {
        this.table = table;
    }

    /**
     * <br>
     * The amount of throughput consumed on the table affected by the operation.
     * <br>
     *
     * @return The amount of throughput consumed on the table affected by the operation.
     */

    public Capacity getTable() {
        return this.table;
    }

    /**
     * <br>
     * The amount of throughput consumed on the table affected by the operation.
     * <br>
     *
     * @param table
     *        The amount of throughput consumed on the table affected by the operation.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity withTable(Capacity table) {
        setTable(table);
        return this;
    }

    /**
     * <br>
     * The amount of throughput consumed on each local index affected by the operation.
     * <br>
     *
     * @return The amount of throughput consumed on each local index affected by the operation.
     */

    public java.util.Map<String, Capacity> getLocalSecondaryIndexes() {
        return localSecondaryIndexes;
    }

    /**
     * <br>
     * The amount of throughput consumed on each local index affected by the operation.
     * <br>
     *
     * @param localSecondaryIndexes
     *        The amount of throughput consumed on each local index affected by the operation.
     */

    public void setLocalSecondaryIndexes(java.util.Map<String, Capacity> localSecondaryIndexes) {
        this.localSecondaryIndexes = localSecondaryIndexes;
    }

    /**
     * <br>
     * The amount of throughput consumed on each local index affected by the operation.
     * <br>
     *
     * @param localSecondaryIndexes
     *        The amount of throughput consumed on each local index affected by the operation.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity withLocalSecondaryIndexes(java.util.Map<String, Capacity> localSecondaryIndexes) {
        setLocalSecondaryIndexes(localSecondaryIndexes);
        return this;
    }

    public ConsumedCapacity addLocalSecondaryIndexesEntry(String key, Capacity value) {
        if (null == this.localSecondaryIndexes) {
            this.localSecondaryIndexes = new java.util.HashMap<String, Capacity>();
        }
        if (this.localSecondaryIndexes.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.localSecondaryIndexes.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into LocalSecondaryIndexes.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity clearLocalSecondaryIndexesEntries() {
        this.localSecondaryIndexes = null;
        return this;
    }

    /**
     * <br>
     * The amount of throughput consumed on each global index affected by the operation.
     * <br>
     *
     * @return The amount of throughput consumed on each global index affected by the operation.
     */

    public java.util.Map<String, Capacity> getGlobalSecondaryIndexes() {
        return globalSecondaryIndexes;
    }

    /**
     * <br>
     * The amount of throughput consumed on each global index affected by the operation.
     * <br>
     *
     * @param globalSecondaryIndexes
     *        The amount of throughput consumed on each global index affected by the operation.
     */

    public void setGlobalSecondaryIndexes(java.util.Map<String, Capacity> globalSecondaryIndexes) {
        this.globalSecondaryIndexes = globalSecondaryIndexes;
    }

    /**
     * <br>
     * The amount of throughput consumed on each global index affected by the operation.
     * <br>
     *
     * @param globalSecondaryIndexes
     *        The amount of throughput consumed on each global index affected by the operation.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity withGlobalSecondaryIndexes(java.util.Map<String, Capacity> globalSecondaryIndexes) {
        setGlobalSecondaryIndexes(globalSecondaryIndexes);
        return this;
    }

    public ConsumedCapacity addGlobalSecondaryIndexesEntry(String key, Capacity value) {
        if (null == this.globalSecondaryIndexes) {
            this.globalSecondaryIndexes = new java.util.HashMap<String, Capacity>();
        }
        if (this.globalSecondaryIndexes.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.globalSecondaryIndexes.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into GlobalSecondaryIndexes.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ConsumedCapacity clearGlobalSecondaryIndexesEntries() {
        this.globalSecondaryIndexes = null;
        return this;
    }
}
