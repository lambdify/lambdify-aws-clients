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
 * Represents the output of a <code>GetItem</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/GetItem" target="_top">AWS API
 *      Documentation</a>
 */
@ToString @EqualsAndHashCode
public class GetItemResult implements Serializable {

    /**
     * <br>
     * A map of attribute names to <code>AttributeValue</code> objects, as specified by
     * <code>ProjectionExpression</code>.
     * <br>
     */
    @JsonProperty("Item")
    private java.util.Map<String, AttributeValue> item;
    /**
     * <br>
     * The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
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
     * A map of attribute names to <code>AttributeValue</code> objects, as specified by
     * <code>ProjectionExpression</code>.
     * <br>
     *
     * @return A map of attribute names to <code>AttributeValue</code> objects, as specified by
     *         <code>ProjectionExpression</code>.
     */

    public java.util.Map<String, AttributeValue> getItem() {
        return item;
    }

    /**
     * <br>
     * A map of attribute names to <code>AttributeValue</code> objects, as specified by
     * <code>ProjectionExpression</code>.
     * <br>
     *
     * @param item
     *        A map of attribute names to <code>AttributeValue</code> objects, as specified by
     *        <code>ProjectionExpression</code>.
     */

    public void setItem(java.util.Map<String, AttributeValue> item) {
        this.item = item;
    }

    /**
     * <br>
     * A map of attribute names to <code>AttributeValue</code> objects, as specified by
     * <code>ProjectionExpression</code>.
     * <br>
     *
     * @param item
     *        A map of attribute names to <code>AttributeValue</code> objects, as specified by
     *        <code>ProjectionExpression</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemResult withItem(java.util.Map<String, AttributeValue> item) {
        setItem(item);
        return this;
    }

    public GetItemResult addItemEntry(String key, AttributeValue value) {
        if (null == this.item) {
            this.item = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.item.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.item.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into Item.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemResult clearItemEntries() {
        this.item = null;
        return this;
    }

    /**
     * <br>
     * The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param consumedCapacity
     *        The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
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
     * The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
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
     * The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
     * provisioned throughput consumed, along with statistics for the table and any indexes involved in the operation.
     * <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code> parameter was
     * specified. For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     * >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param consumedCapacity
     *        The capacity units consumed by the <code>GetItem</code> operation. The data returned includes the total
     *        provisioned throughput consumed, along with statistics for the table and any indexes involved in the
     *        operation. <code>ConsumedCapacity</code> is only returned if the <code>ReturnConsumedCapacity</code>
     *        parameter was specified. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ProvisionedThroughputIntro.html"
     *        >Provisioned Throughput</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity) {
        setConsumedCapacity(consumedCapacity);
        return this;
    }
}
