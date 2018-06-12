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
import lambdify.aws.events.dynamodb.AttributeValue;
import lombok.*;

/**
 * <br>
 * Information about item collections, if any, that were affected by the operation. <code>ItemCollectionMetrics</code>
 * is only returned if the request asked for it. If the table does not have any local secondary indexes, this
 * information is not returned in the response.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/ItemCollectionMetrics" target="_top">AWS API
 *      Documentation</a>
 */
@ToString @EqualsAndHashCode
public class ItemCollectionMetrics implements Serializable, Cloneable {

    /**
     * <br>
     * The partition key value of the item collection. This value is the same as the partition key value of the item.
     * <br>
     */
    @JsonProperty("ItemCollectionKey")
    private java.util.Map<String, AttributeValue> itemCollectionKey;
    /**
     * <br>
     * An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower bound and
     * an upper bound for the estimate. The estimate includes the size of all the items in the table, plus the size of
     * all attributes projected into all of the local secondary indexes on that table. Use this estimate to measure
     * whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     */
    @JsonProperty("SizeEstimateRangeGB")
    private java.util.List<Double> sizeEstimateRangeGB;

    /**
     * <br>
     * The partition key value of the item collection. This value is the same as the partition key value of the item.
     * <br>
     *
     * @return The partition key value of the item collection. This value is the same as the partition key value of the
     *         item.
     */

    public java.util.Map<String, AttributeValue> getItemCollectionKey() {
        return itemCollectionKey;
    }

    /**
     * <br>
     * The partition key value of the item collection. This value is the same as the partition key value of the item.
     * <br>
     *
     * @param itemCollectionKey
     *        The partition key value of the item collection. This value is the same as the partition key value of the
     *        item.
     */

    public void setItemCollectionKey(java.util.Map<String, AttributeValue> itemCollectionKey) {
        this.itemCollectionKey = itemCollectionKey;
    }

    /**
     * <br>
     * The partition key value of the item collection. This value is the same as the partition key value of the item.
     * <br>
     *
     * @param itemCollectionKey
     *        The partition key value of the item collection. This value is the same as the partition key value of the
     *        item.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ItemCollectionMetrics withItemCollectionKey(java.util.Map<String, AttributeValue> itemCollectionKey) {
        setItemCollectionKey(itemCollectionKey);
        return this;
    }

    public ItemCollectionMetrics addItemCollectionKeyEntry(String key, AttributeValue value) {
        if (null == this.itemCollectionKey) {
            this.itemCollectionKey = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.itemCollectionKey.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.itemCollectionKey.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ItemCollectionKey.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ItemCollectionMetrics clearItemCollectionKeyEntries() {
        this.itemCollectionKey = null;
        return this;
    }

    /**
     * <br>
     * An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower bound and
     * an upper bound for the estimate. The estimate includes the size of all the items in the table, plus the size of
     * all attributes projected into all of the local secondary indexes on that table. Use this estimate to measure
     * whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     *
     * @return An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower
     *         bound and an upper bound for the estimate. The estimate includes the size of all the items in the table,
     *         plus the size of all attributes projected into all of the local secondary indexes on that table. Use this
     *         estimate to measure whether a local secondary index is approaching its size limit.<br>
     *         <br>
     *         The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *         estimate.
     */

    public java.util.List<Double> getSizeEstimateRangeGB() {
        return sizeEstimateRangeGB;
    }

    /**
     * <br>
     * An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower bound and
     * an upper bound for the estimate. The estimate includes the size of all the items in the table, plus the size of
     * all attributes projected into all of the local secondary indexes on that table. Use this estimate to measure
     * whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     *
     * @param sizeEstimateRangeGB
     *        An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower
     *        bound and an upper bound for the estimate. The estimate includes the size of all the items in the table,
     *        plus the size of all attributes projected into all of the local secondary indexes on that table. Use this
     *        estimate to measure whether a local secondary index is approaching its size limit.<br>
     *        <br>
     *        The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *        estimate.
     */

    public void setSizeEstimateRangeGB(java.util.List<Double> sizeEstimateRangeGB) {
        this.sizeEstimateRangeGB = sizeEstimateRangeGB;
    }

    /**
     * <br>
     * An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower bound and
     * an upper bound for the estimate. The estimate includes the size of all the items in the table, plus the size of
     * all attributes projected into all of the local secondary indexes on that table. Use this estimate to measure
     * whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     * <br>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setSizeEstimateRangeGB(java.util.List)} or {@link #withSizeEstimateRangeGB(java.util.List)}
     * if you want to override the existing values.
     * <br>
     *
     * @param sizeEstimateRangeGB
     *        An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower
     *        bound and an upper bound for the estimate. The estimate includes the size of all the items in the table,
     *        plus the size of all attributes projected into all of the local secondary indexes on that table. Use this
     *        estimate to measure whether a local secondary index is approaching its size limit.<br>
     *        <br>
     *        The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *        estimate.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ItemCollectionMetrics withSizeEstimateRangeGB(Double... sizeEstimateRangeGB) {
        if (this.sizeEstimateRangeGB == null) {
            setSizeEstimateRangeGB(new java.util.ArrayList<Double>(sizeEstimateRangeGB.length));
        }
        for (Double ele : sizeEstimateRangeGB) {
            this.sizeEstimateRangeGB.add(ele);
        }
        return this;
    }

    /**
     * <br>
     * An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower bound and
     * an upper bound for the estimate. The estimate includes the size of all the items in the table, plus the size of
     * all attributes projected into all of the local secondary indexes on that table. Use this estimate to measure
     * whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     *
     * @param sizeEstimateRangeGB
     *        An estimate of item collection size, in gigabytes. This value is a two-element array containing a lower
     *        bound and an upper bound for the estimate. The estimate includes the size of all the items in the table,
     *        plus the size of all attributes projected into all of the local secondary indexes on that table. Use this
     *        estimate to measure whether a local secondary index is approaching its size limit.<br>
     *        <br>
     *        The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *        estimate.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ItemCollectionMetrics withSizeEstimateRangeGB(java.util.List<Double> sizeEstimateRangeGB) {
        setSizeEstimateRangeGB(sizeEstimateRangeGB);
        return this;
    }
}
