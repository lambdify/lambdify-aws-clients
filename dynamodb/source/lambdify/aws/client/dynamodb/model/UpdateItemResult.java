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
 * Represents the output of an <code>UpdateItem</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/UpdateItem" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class UpdateItemResult implements Serializable {

    /**
     * <br>
     * A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only appears if
     * <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the request. Each element
     * represents one attribute.
     * <br>
     */
    @JsonProperty("Attributes")
    private java.util.Map<String, AttributeValue> attributes;
    /**
     * <br>
     * The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ConsumedCapacity")
    private ConsumedCapacity consumedCapacity;
    /**
     * <br>
     * Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     * <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code> parameter was
     * specified. If the table does not have any local secondary indexes, this information is not returned in the
     * response.
     * <br>
     * <br>
     * Each <code>ItemCollectionMetrics</code> element consists of:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     * partition key value of the item itself.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a two-element
     * array containing a lower bound and an upper bound for the estimate. The estimate includes the size of all the
     * items in the table, plus the size of all attributes projected into all of the local secondary indexes on that
     * table. Use this estimate to measure whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     * </li>
     * </ul>
     */
    @JsonProperty("ItemCollectionMetrics")
    private ItemCollectionMetrics itemCollectionMetrics;

    /**
     * <br>
     * A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only appears if
     * <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the request. Each element
     * represents one attribute.
     * <br>
     *
     * @return A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only
     *         appears if <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the
     *         request. Each element represents one attribute.
     */

    public java.util.Map<String, AttributeValue> getAttributes() {
        return attributes;
    }

    /**
     * <br>
     * A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only appears if
     * <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the request. Each element
     * represents one attribute.
     * <br>
     *
     * @param attributes
     *        A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only
     *        appears if <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the
     *        request. Each element represents one attribute.
     */

    public void setAttributes(java.util.Map<String, AttributeValue> attributes) {
        this.attributes = attributes;
    }

    /**
     * <br>
     * A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only appears if
     * <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the request. Each element
     * represents one attribute.
     * <br>
     *
     * @param attributes
     *        A map of attribute values as they appeared before the <code>UpdateItem</code> operation. This map only
     *        appears if <code>ReturnValues</code> was specified as something other than <code>NONE</code> in the
     *        request. Each element represents one attribute.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemResult withAttributes(java.util.Map<String, AttributeValue> attributes) {
        setAttributes(attributes);
        return this;
    }

    public UpdateItemResult addAttributesEntry(String key, AttributeValue value) {
        if (null == this.attributes) {
            this.attributes = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.attributes.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.attributes.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into Attributes.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemResult clearAttributesEntries() {
        this.attributes = null;
        return this;
    }

    /**
     * <br>
     * The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param consumedCapacity
     *        The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the total
     *        provisioned throughput consumed, along with statistics for the table and any indexes involved in the
     *        operation. <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code>
     *        parameter was specified. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     *        >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setConsumedCapacity(ConsumedCapacity consumedCapacity) {
        this.consumedCapacity = consumedCapacity;
    }

    /**
     * <br>
     * The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the
     *         total provisioned throughput consumed, along with statistics for the table and any indexes involved in
     *         the operation. <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code>
     *         parameter was specified. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     *         >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    /**
     * <br>
     * The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param consumedCapacity
     *        The capacity units consumed by the <code>UpdateItem</code> operation. The data returned includes the total
     *        provisioned throughput consumed, along with statistics for the table and any indexes involved in the
     *        operation. <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code>
     *        parameter was specified. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     *        >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity) {
        setConsumedCapacity(consumedCapacity);
        return this;
    }

    /**
     * <br>
     * Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     * <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code> parameter was
     * specified. If the table does not have any local secondary indexes, this information is not returned in the
     * response.
     * <br>
     * <br>
     * Each <code>ItemCollectionMetrics</code> element consists of:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     * partition key value of the item itself.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a two-element
     * array containing a lower bound and an upper bound for the estimate. The estimate includes the size of all the
     * items in the table, plus the size of all attributes projected into all of the local secondary indexes on that
     * table. Use this estimate to measure whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     * </li>
     * </ul>
     * 
     * @param itemCollectionMetrics
     *        Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     *        <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code>
     *        parameter was specified. If the table does not have any local secondary indexes, this information is not
     *        returned in the response.<br>
     *        <br>
     *        Each <code>ItemCollectionMetrics</code> element consists of:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     *        partition key value of the item itself.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a
     *        two-element array containing a lower bound and an upper bound for the estimate. The estimate includes the
     *        size of all the items in the table, plus the size of all attributes projected into all of the local
     *        secondary indexes on that table. Use this estimate to measure whether a local secondary index is
     *        approaching its size limit.
     *        <br>
     *        <br>
     *        The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *        estimate.
     *        <br>
     *        </li>
     */

    public void setItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics) {
        this.itemCollectionMetrics = itemCollectionMetrics;
    }

    /**
     * <br>
     * Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     * <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code> parameter was
     * specified. If the table does not have any local secondary indexes, this information is not returned in the
     * response.
     * <br>
     * <br>
     * Each <code>ItemCollectionMetrics</code> element consists of:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     * partition key value of the item itself.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a two-element
     * array containing a lower bound and an upper bound for the estimate. The estimate includes the size of all the
     * items in the table, plus the size of all attributes projected into all of the local secondary indexes on that
     * table. Use this estimate to measure whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     * </li>
     * </ul>
     * 
     * @return Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     *         <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code>
     *         parameter was specified. If the table does not have any local secondary indexes, this information is not
     *         returned in the response.<br>
     *         <br>
     *         Each <code>ItemCollectionMetrics</code> element consists of:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     *         partition key value of the item itself.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a
     *         two-element array containing a lower bound and an upper bound for the estimate. The estimate includes the
     *         size of all the items in the table, plus the size of all attributes projected into all of the local
     *         secondary indexes on that table. Use this estimate to measure whether a local secondary index is
     *         approaching its size limit.
     *         <br>
     *         <br>
     *         The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *         estimate.
     *         <br>
     *         </li>
     */

    public ItemCollectionMetrics getItemCollectionMetrics() {
        return this.itemCollectionMetrics;
    }

    /**
     * <br>
     * Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     * <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code> parameter was
     * specified. If the table does not have any local secondary indexes, this information is not returned in the
     * response.
     * <br>
     * <br>
     * Each <code>ItemCollectionMetrics</code> element consists of:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     * partition key value of the item itself.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a two-element
     * array containing a lower bound and an upper bound for the estimate. The estimate includes the size of all the
     * items in the table, plus the size of all attributes projected into all of the local secondary indexes on that
     * table. Use this estimate to measure whether a local secondary index is approaching its size limit.
     * <br>
     * <br>
     * The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the estimate.
     * <br>
     * </li>
     * </ul>
     * 
     * @param itemCollectionMetrics
     *        Information about item collections, if any, that were affected by the <code>UpdateItem</code> operation.
     *        <code>ItemCollectionMetrics</code> is only returned if the <code>ReturnItemCollectionMetrics</code>
     *        parameter was specified. If the table does not have any local secondary indexes, this information is not
     *        returned in the response.<br>
     *        <br>
     *        Each <code>ItemCollectionMetrics</code> element consists of:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>ItemCollectionKey</code> - The partition key value of the item collection. This is the same as the
     *        partition key value of the item itself.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>SizeEstimateRange</code> - An estimate of item collection size, in gigabytes. This value is a
     *        two-element array containing a lower bound and an upper bound for the estimate. The estimate includes the
     *        size of all the items in the table, plus the size of all attributes projected into all of the local
     *        secondary indexes on that table. Use this estimate to measure whether a local secondary index is
     *        approaching its size limit.
     *        <br>
     *        <br>
     *        The estimate is subject to change over time; therefore, do not rely on the precision or accuracy of the
     *        estimate.
     *        <br>
     *        </li>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemResult withItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics) {
        setItemCollectionMetrics(itemCollectionMetrics);
        return this;
    }
}
