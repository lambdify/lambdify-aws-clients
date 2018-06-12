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
 * Represents the output of a <code>Scan</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/Scan" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class ScanResult implements Serializable {

    /**
     * <br>
     * An array of item attributes that match the scan criteria. Each element in this array consists of an attribute
     * name and the value for that attribute.
     * <br>
     */
    @JsonProperty("Items")
    private java.util.List<java.util.Map<String, AttributeValue>> items;
    /**
     * <br>
     * The number of items in the response.
     * <br>
     * <br>
     * If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items returned after
     * the filter was applied, and <code>ScannedCount</code> is the number of matching items before the filter was
     * applied.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>Count</code> is the same as <code>ScannedCount</code>.
     * <br>
     */
    @JsonProperty("Count")
    private Integer count;
    /**
     * <br>
     * The number of items evaluated, before any <code>ScanFilter</code> is applied. A high <code>ScannedCount</code>
     * value with few, or no, <code>Count</code> results indicates an inefficient <code>Scan</code> operation. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     * ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>ScannedCount</code> is the same as <code>Count</code>.
     * <br>
     */
    @JsonProperty("ScannedCount")
    private Integer scannedCount;
    /**
     * <br>
     * The primary key of the item where the operation stopped, inclusive of the previous result set. Use this value to
     * start a new operation, excluding this value in the new request.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there is no
     * more data to be retrieved.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in the result
     * set. The only way to know when you have reached the end of the result set is when <code>LastEvaluatedKey</code>
     * is empty.
     * <br>
     */
    @JsonProperty("LastEvaluatedKey")
    private java.util.Map<String, AttributeValue> lastEvaluatedKey;
    /**
     * <br>
     * The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total provisioned
     * throughput consumed, along with statistics for the table and any indexes involved in the operation.
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
     * An array of item attributes that match the scan criteria. Each element in this array consists of an attribute
     * name and the value for that attribute.
     * <br>
     *
     * @return An array of item attributes that match the scan criteria. Each element in this array consists of an
     *         attribute name and the value for that attribute.
     */

    public java.util.List<java.util.Map<String, AttributeValue>> getItems() {
        return items;
    }

    /**
     * <br>
     * An array of item attributes that match the scan criteria. Each element in this array consists of an attribute
     * name and the value for that attribute.
     * <br>
     *
     * @param items
     *        An array of item attributes that match the scan criteria. Each element in this array consists of an
     *        attribute name and the value for that attribute.
     */

    public void setItems(java.util.Collection<java.util.Map<String, AttributeValue>> items) {
        if (items == null) {
            this.items = null;
            return;
        }

        this.items = new java.util.ArrayList<java.util.Map<String, AttributeValue>>(items);
    }

    /**
     * <br>
     * An array of item attributes that match the scan criteria. Each element in this array consists of an attribute
     * name and the value for that attribute.
     * <br>
     * <br>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setItems(java.util.Collection)} or {@link #withItems(java.util.Collection)} if you want to override the
     * existing values.
     * <br>
     *
     * @param items
     *        An array of item attributes that match the scan criteria. Each element in this array consists of an
     *        attribute name and the value for that attribute.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult withItems(java.util.Map<String, AttributeValue>... items) {
        if (this.items == null) {
            setItems(new java.util.ArrayList<java.util.Map<String, AttributeValue>>(items.length));
        }
        for (java.util.Map<String, AttributeValue> ele : items) {
            this.items.add(ele);
        }
        return this;
    }

    /**
     * <br>
     * An array of item attributes that match the scan criteria. Each element in this array consists of an attribute
     * name and the value for that attribute.
     * <br>
     *
     * @param items
     *        An array of item attributes that match the scan criteria. Each element in this array consists of an
     *        attribute name and the value for that attribute.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult withItems(java.util.Collection<java.util.Map<String, AttributeValue>> items) {
        setItems(items);
        return this;
    }

    /**
     * <br>
     * The number of items in the response.
     * <br>
     * <br>
     * If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items returned after
     * the filter was applied, and <code>ScannedCount</code> is the number of matching items before the filter was
     * applied.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>Count</code> is the same as <code>ScannedCount</code>.
     * <br>
     *
     * @param count
     *        The number of items in the response.<br>
     *        <br>
     *        If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items returned
     *        after the filter was applied, and <code>ScannedCount</code> is the number of matching items before the
     *        filter was applied.
     *        <br>
     *        <br>
     *        If you did not use a filter in the request, then <code>Count</code> is the same as
     *        <code>ScannedCount</code>.
     */

    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * <br>
     * The number of items in the response.
     * <br>
     * <br>
     * If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items returned after
     * the filter was applied, and <code>ScannedCount</code> is the number of matching items before the filter was
     * applied.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>Count</code> is the same as <code>ScannedCount</code>.
     * <br>
     *
     * @return The number of items in the response.<br>
     *         <br>
     *         If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items
     *         returned after the filter was applied, and <code>ScannedCount</code> is the number of matching items
     *         before the filter was applied.
     *         <br>
     *         <br>
     *         If you did not use a filter in the request, then <code>Count</code> is the same as
     *         <code>ScannedCount</code>.
     */

    public Integer getCount() {
        return this.count;
    }

    /**
     * <br>
     * The number of items in the response.
     * <br>
     * <br>
     * If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items returned after
     * the filter was applied, and <code>ScannedCount</code> is the number of matching items before the filter was
     * applied.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>Count</code> is the same as <code>ScannedCount</code>.
     * <br>
     *
     * @param count
     *        The number of items in the response.<br>
     *        <br>
     *        If you set <code>ScanFilter</code> in the request, then <code>Count</code> is the number of items returned
     *        after the filter was applied, and <code>ScannedCount</code> is the number of matching items before the
     *        filter was applied.
     *        <br>
     *        <br>
     *        If you did not use a filter in the request, then <code>Count</code> is the same as
     *        <code>ScannedCount</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult withCount(Integer count) {
        setCount(count);
        return this;
    }

    /**
     * <br>
     * The number of items evaluated, before any <code>ScanFilter</code> is applied. A high <code>ScannedCount</code>
     * value with few, or no, <code>Count</code> results indicates an inefficient <code>Scan</code> operation. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     * ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>ScannedCount</code> is the same as <code>Count</code>.
     * <br>
     *
     * @param scannedCount
     *        The number of items evaluated, before any <code>ScanFilter</code> is applied. A high
     *        <code>ScannedCount</code> value with few, or no, <code>Count</code> results indicates an inefficient
     *        <code>Scan</code> operation. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     *        ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.<br>
     *        <br>
     *        If you did not use a filter in the request, then <code>ScannedCount</code> is the same as
     *        <code>Count</code>.
     */

    public void setScannedCount(Integer scannedCount) {
        this.scannedCount = scannedCount;
    }

    /**
     * <br>
     * The number of items evaluated, before any <code>ScanFilter</code> is applied. A high <code>ScannedCount</code>
     * value with few, or no, <code>Count</code> results indicates an inefficient <code>Scan</code> operation. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     * ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>ScannedCount</code> is the same as <code>Count</code>.
     * <br>
     *
     * @return The number of items evaluated, before any <code>ScanFilter</code> is applied. A high
     *         <code>ScannedCount</code> value with few, or no, <code>Count</code> results indicates an inefficient
     *         <code>Scan</code> operation. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     *         ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.<br>
     *         <br>
     *         If you did not use a filter in the request, then <code>ScannedCount</code> is the same as
     *         <code>Count</code>.
     */

    public Integer getScannedCount() {
        return this.scannedCount;
    }

    /**
     * <br>
     * The number of items evaluated, before any <code>ScanFilter</code> is applied. A high <code>ScannedCount</code>
     * value with few, or no, <code>Count</code> results indicates an inefficient <code>Scan</code> operation. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     * ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * If you did not use a filter in the request, then <code>ScannedCount</code> is the same as <code>Count</code>.
     * <br>
     *
     * @param scannedCount
     *        The number of items evaluated, before any <code>ScanFilter</code> is applied. A high
     *        <code>ScannedCount</code> value with few, or no, <code>Count</code> results indicates an inefficient
     *        <code>Scan</code> operation. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#Count">Count and
     *        ScannedCount</a> in the <i>Amazon DynamoDB Developer Guide</i>.<br>
     *        <br>
     *        If you did not use a filter in the request, then <code>ScannedCount</code> is the same as
     *        <code>Count</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult withScannedCount(Integer scannedCount) {
        setScannedCount(scannedCount);
        return this;
    }

    /**
     * <br>
     * The primary key of the item where the operation stopped, inclusive of the previous result set. Use this value to
     * start a new operation, excluding this value in the new request.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there is no
     * more data to be retrieved.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in the result
     * set. The only way to know when you have reached the end of the result set is when <code>LastEvaluatedKey</code>
     * is empty.
     * <br>
     *
     * @return The primary key of the item where the operation stopped, inclusive of the previous result set. Use this
     *         value to start a new operation, excluding this value in the new request.<br>
     *         <br>
     *         If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there
     *         is no more data to be retrieved.
     *         <br>
     *         <br>
     *         If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in
     *         the result set. The only way to know when you have reached the end of the result set is when
     *         <code>LastEvaluatedKey</code> is empty.
     */

    public java.util.Map<String, AttributeValue> getLastEvaluatedKey() {
        return lastEvaluatedKey;
    }

    /**
     * <br>
     * The primary key of the item where the operation stopped, inclusive of the previous result set. Use this value to
     * start a new operation, excluding this value in the new request.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there is no
     * more data to be retrieved.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in the result
     * set. The only way to know when you have reached the end of the result set is when <code>LastEvaluatedKey</code>
     * is empty.
     * <br>
     *
     * @param lastEvaluatedKey
     *        The primary key of the item where the operation stopped, inclusive of the previous result set. Use this
     *        value to start a new operation, excluding this value in the new request.<br>
     *        <br>
     *        If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there is
     *        no more data to be retrieved.
     *        <br>
     *        <br>
     *        If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in the
     *        result set. The only way to know when you have reached the end of the result set is when
     *        <code>LastEvaluatedKey</code> is empty.
     */

    public void setLastEvaluatedKey(java.util.Map<String, AttributeValue> lastEvaluatedKey) {
        this.lastEvaluatedKey = lastEvaluatedKey;
    }

    /**
     * <br>
     * The primary key of the item where the operation stopped, inclusive of the previous result set. Use this value to
     * start a new operation, excluding this value in the new request.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there is no
     * more data to be retrieved.
     * <br>
     * <br>
     * If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in the result
     * set. The only way to know when you have reached the end of the result set is when <code>LastEvaluatedKey</code>
     * is empty.
     * <br>
     *
     * @param lastEvaluatedKey
     *        The primary key of the item where the operation stopped, inclusive of the previous result set. Use this
     *        value to start a new operation, excluding this value in the new request.<br>
     *        <br>
     *        If <code>LastEvaluatedKey</code> is empty, then the "last page" of results has been processed and there is
     *        no more data to be retrieved.
     *        <br>
     *        <br>
     *        If <code>LastEvaluatedKey</code> is not empty, it does not necessarily mean that there is more data in the
     *        result set. The only way to know when you have reached the end of the result set is when
     *        <code>LastEvaluatedKey</code> is empty.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult withLastEvaluatedKey(java.util.Map<String, AttributeValue> lastEvaluatedKey) {
        setLastEvaluatedKey(lastEvaluatedKey);
        return this;
    }

    public ScanResult addLastEvaluatedKeyEntry(String key, AttributeValue value) {
        if (null == this.lastEvaluatedKey) {
            this.lastEvaluatedKey = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.lastEvaluatedKey.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.lastEvaluatedKey.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into LastEvaluatedKey.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult clearLastEvaluatedKeyEntries() {
        this.lastEvaluatedKey = null;
        return this;
    }

    /**
     * <br>
     * The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total provisioned
     * throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param consumedCapacity
     *        The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total
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
     * The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total provisioned
     * throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total
     *         provisioned throughput consumed, along with statistics for the table and any indexes involved in the
     *         operation. <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code>
     *         parameter was specified. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     *         >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    /**
     * <br>
     * The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total provisioned
     * throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param consumedCapacity
     *        The capacity units consumed by the <code>Scan</code> operation. The data returned includes the total
     *        provisioned throughput consumed, along with statistics for the table and any indexes involved in the
     *        operation. <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code>
     *        parameter was specified. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     *        >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanResult withConsumedCapacity(ConsumedCapacity consumedCapacity) {
        setConsumedCapacity(consumedCapacity);
        return this;
    }
}
