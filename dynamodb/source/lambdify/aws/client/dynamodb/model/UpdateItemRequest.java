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
import lambdify.aws.events.dynamodb.AttributeValue;
import lombok.*;

/**
 * <br>
 * Represents the input of an <code>UpdateItem</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/UpdateItem" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class UpdateItemRequest implements Serializable {

    /**
     * <br>
     * The name of the table containing the item to update.
     * <br>
     */
    @JsonProperty("TableName")
    private String tableName;
    /**
     * <br>
     * The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     * attribute.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     */
    @JsonProperty("Key")
    private java.util.Map<String, AttributeValue> key;
    /**
     * <br>
     * This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     * >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("AttributeUpdates")
    private java.util.Map<String, AttributeValueUpdate> attributeUpdates;
    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("Expected")
    private java.util.Map<String, ExpectedAttributeValue> expected;
    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ConditionalOperator")
    private String conditionalOperator;
    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or after they
     * were updated. For <code>UpdateItem</code>, the valid values are:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     * operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * </ul>
     * <br>
     * There is no additional cost associated with requesting a return value aside from the small network and processing
     * overhead of receiving a larger response. No Read Capacity Units are consumed.
     * <br>
     * <br>
     * Values returned are strongly consistent
     * <br>
     */
    @JsonProperty("ReturnValues")
    private String returnValues;

    @JsonProperty("ReturnConsumedCapacity")
    private String returnConsumedCapacity;
    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     */
    @JsonProperty("ReturnItemCollectionMetrics")
    private String returnItemCollectionMetrics;
    /**
     * <br>
     * An expression that defines one or more attributes to be updated, the action to be performed on them, and new
     * value(s) for them.
     * <br>
     * <br>
     * The following action values are available for <code>UpdateExpression</code>.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already exist,
     * they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an attribute that
     * is of type Number. For example: <code>SET myNum = myNum + :val</code>
     * <br>
     * <br>
     * <code>SET</code> supports the following functions:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified path,
     * then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use this function
     * to avoid overwriting an attribute that may already be present in the item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can append
     * the new element to the start or the end of the list by reversing the order of the operands.
     * <br>
     * </li>
     * </ul>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>REMOVE</code> - Removes one or more attributes from an item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     * attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses <code>0</code> as the initial value.
     * <br>
     * <br>
     * Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value that
     * doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example, suppose that the
     * item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide to <code>ADD</code> the
     * number <code>3</code> to this attribute anyway. DynamoDB will create the <i>itemcount</i> attribute, set its
     * initial value to <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i>
     * attribute in the item, with a value of <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is added to
     * the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the <code>ADD</code>
     * action specified <code>[3]</code>, then the final attribute value is <code>[1,2,3]</code>. An error occurs if an
     * <code>ADD</code> action is specified for a set attribute and the attribute type specified does not match the
     * existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings.
     * <br>
     * </li>
     * </ul>
     * <important>
     * <br>
     * The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can only be
     * used on top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * <li>
     * <br>
     * <code>DELETE</code> - Deletes an element from a set.
     * <br>
     * <br>
     * If a set of values is specified, then those values are subtracted from the old set. For example, if the attribute
     * value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies <code>[a,c]</code>, then the
     * final attribute value is <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * <important>
     * <br>
     * The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be used on
     * top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * </ul>
     * <br>
     * You can have many actions in a single expression, such as the following:
     * <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     * <br>
     * <br>
     * For more information on update expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html">Modifying Items
     * and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("UpdateExpression")
    private String updateExpression;
    /**
     * <br>
     * A condition that must be satisfied in order for a conditional update to succeed.
     * <br>
     * <br>
     * An expression can contain any of the following:
     * <br>
     * <ul>
     * <li>
     * <br>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     * <br>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     * <br>
     * </li>
     * <li>
     * <br>
     * Logical operators: <code>AND | OR | NOT</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ConditionExpression")
    private String conditionExpression;
    /**
     * <br>
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * <br>
     * </li>
     * <li>
     * <br>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * <br>
     * </li>
     * <li>
     * <br>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Percentile</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>{"#P":"Percentile"}</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * You could then use this substitution in an expression, as in this example:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#P = :val</code>
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * <br>
     * </note>
     * <br>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ExpressionAttributeNames")
    private java.util.Map<String, String> expressionAttributeNames;
    /**
     * <br>
     * One or more values that can be substituted in an expression.
     * <br>
     * <br>
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <br>
     * <br>
     * <code>Available | Backordered | Discontinued</code>
     * <br>
     * <br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <br>
     * <br>
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <br>
     * <br>
     * You could then use these values in an expression, such as this:
     * <br>
     * <br>
     * <code>ProductStatus IN (:avail, :back, :disc)</code>
     * <br>
     * <br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ExpressionAttributeValues")
    private java.util.Map<String, AttributeValue> expressionAttributeValues;

    /**
     * Default constructor for UpdateItemRequest object. Callers should use the setter or fluent setter (with...)
     * methods to initialize the object after creating it.
     */
    public UpdateItemRequest() {
    }

    /**
     * Constructs a new UpdateItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the item to update.
     * @param key
     *        The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     *        attribute.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @param attributeUpdates
     *        This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     *        >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public UpdateItemRequest(String tableName, java.util.Map<String, AttributeValue> key, java.util.Map<String, AttributeValueUpdate> attributeUpdates) {
        setTableName(tableName);
        setKey(key);
        setAttributeUpdates(attributeUpdates);
    }

    /**
     * Constructs a new UpdateItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the item to update.
     * @param key
     *        The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     *        attribute.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @param attributeUpdates
     *        This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     *        >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *        after they were updated. For <code>UpdateItem</code>, the valid values are:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        There is no additional cost associated with requesting a return value aside from the small network and
     *        processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *        <br>
     *        <br>
     *        Values returned are strongly consistent
     */
    public UpdateItemRequest(String tableName, java.util.Map<String, AttributeValue> key, java.util.Map<String, AttributeValueUpdate> attributeUpdates,
            String returnValues) {
        setTableName(tableName);
        setKey(key);
        setAttributeUpdates(attributeUpdates);
        setReturnValues(returnValues);
    }

    /**
     * Constructs a new UpdateItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the item to update.
     * @param key
     *        The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     *        attribute.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @param attributeUpdates
     *        This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     *        >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *        after they were updated. For <code>UpdateItem</code>, the valid values are:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        There is no additional cost associated with requesting a return value aside from the small network and
     *        processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *        <br>
     *        <br>
     *        Values returned are strongly consistent
     */
    public UpdateItemRequest(String tableName, java.util.Map<String, AttributeValue> key, java.util.Map<String, AttributeValueUpdate> attributeUpdates,
            ReturnValue returnValues) {
        setTableName(tableName);
        setKey(key);
        setAttributeUpdates(attributeUpdates);
        setReturnValues(returnValues.toString());
    }

    /**
     * <br>
     * The name of the table containing the item to update.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the item to update.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * <br>
     * The name of the table containing the item to update.
     * <br>
     *
     * @return The name of the table containing the item to update.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * <br>
     * The name of the table containing the item to update.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the item to update.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * <br>
     * The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     * attribute.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     *
     * @return The primary key of the item to be updated. Each element consists of an attribute name and a value for
     *         that attribute.<br>
     *         <br>
     *         For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *         only need to provide a value for the partition key. For a composite primary key, you must provide values
     *         for both the partition key and the sort key.
     */

    public java.util.Map<String, AttributeValue> getKey() {
        return key;
    }

    /**
     * <br>
     * The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     * attribute.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     *
     * @param key
     *        The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     *        attribute.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     */

    public void setKey(java.util.Map<String, AttributeValue> key) {
        this.key = key;
    }

    /**
     * <br>
     * The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     * attribute.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     *
     * @param key
     *        The primary key of the item to be updated. Each element consists of an attribute name and a value for that
     *        attribute.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withKey(java.util.Map<String, AttributeValue> key) {
        setKey(key);
        return this;
    }

    public UpdateItemRequest addKeyEntry(String key, AttributeValue value) {
        if (null == this.key) {
            this.key = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.key.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.key.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into Key.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest clearKeyEntries() {
        this.key = null;
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     * >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     *         >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, AttributeValueUpdate> getAttributeUpdates() {
        return attributeUpdates;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     * >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param attributeUpdates
     *        This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     *        >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setAttributeUpdates(java.util.Map<String, AttributeValueUpdate> attributeUpdates) {
        this.attributeUpdates = attributeUpdates;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     * >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param attributeUpdates
     *        This is a legacy parameter. Use <code>UpdateExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributeUpdates.html"
     *        >AttributeUpdates</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withAttributeUpdates(java.util.Map<String, AttributeValueUpdate> attributeUpdates) {
        setAttributeUpdates(attributeUpdates);
        return this;
    }

    public UpdateItemRequest addAttributeUpdatesEntry(String key, AttributeValueUpdate value) {
        if (null == this.attributeUpdates) {
            this.attributeUpdates = new java.util.HashMap<String, AttributeValueUpdate>();
        }
        if (this.attributeUpdates.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.attributeUpdates.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into AttributeUpdates.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest clearAttributeUpdatesEntries() {
        this.attributeUpdates = null;
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a
     *         href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     *         >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, ExpectedAttributeValue> getExpected() {
        return expected;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param expected
     *        This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     *        >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setExpected(java.util.Map<String, ExpectedAttributeValue> expected) {
        this.expected = expected;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param expected
     *        This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     *        >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withExpected(java.util.Map<String, ExpectedAttributeValue> expected) {
        setExpected(expected);
        return this;
    }

    public UpdateItemRequest addExpectedEntry(String key, ExpectedAttributeValue value) {
        if (null == this.expected) {
            this.expected = new java.util.HashMap<String, ExpectedAttributeValue>();
        }
        if (this.expected.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.expected.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into Expected.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest clearExpectedEntries() {
        this.expected = null;
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @see ConditionalOperator
     */

    public void setConditionalOperator(String conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *         href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *         >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @see ConditionalOperator
     */

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ConditionalOperator
     */

    public UpdateItemRequest withConditionalOperator(String conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @see ConditionalOperator
     */

    public void setConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ConditionalOperator
     */

    public UpdateItemRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or after they
     * were updated. For <code>UpdateItem</code>, the valid values are:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     * operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * </ul>
     * <br>
     * There is no additional cost associated with requesting a return value aside from the small network and processing
     * overhead of receiving a larger response. No Read Capacity Units are consumed.
     * <br>
     * <br>
     * Values returned are strongly consistent
     * <br>
     *
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *        after they were updated. For <code>UpdateItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        There is no additional cost associated with requesting a return value aside from the small network and
     *        processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *        <br>
     *        <br>
     *        Values returned are strongly consistent
     * @see ReturnValue
     */

    public void setReturnValues(String returnValues) {
        this.returnValues = returnValues;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or after they
     * were updated. For <code>UpdateItem</code>, the valid values are:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     * operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * </ul>
     * <br>
     * There is no additional cost associated with requesting a return value aside from the small network and processing
     * overhead of receiving a larger response. No Read Capacity Units are consumed.
     * <br>
     * <br>
     * Values returned are strongly consistent
     * <br>
     *
     * @return Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *         after they were updated. For <code>UpdateItem</code>, the valid values are:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *         then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *         operation.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *         operation.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *         operation.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *         operation.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         There is no additional cost associated with requesting a return value aside from the small network and
     *         processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *         <br>
     *         <br>
     *         Values returned are strongly consistent
     * @see ReturnValue
     */

    public String getReturnValues() {
        return this.returnValues;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or after they
     * were updated. For <code>UpdateItem</code>, the valid values are:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     * operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * </ul>
     * <br>
     * There is no additional cost associated with requesting a return value aside from the small network and processing
     * overhead of receiving a larger response. No Read Capacity Units are consumed.
     * <br>
     * <br>
     * Values returned are strongly consistent
     * <br>
     *
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *        after they were updated. For <code>UpdateItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        There is no additional cost associated with requesting a return value aside from the small network and
     *        processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *        <br>
     *        <br>
     *        Values returned are strongly consistent
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnValue
     */

    public UpdateItemRequest withReturnValues(String returnValues) {
        setReturnValues(returnValues);
        return this;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or after they
     * were updated. For <code>UpdateItem</code>, the valid values are:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     * operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * </ul>
     * <br>
     * There is no additional cost associated with requesting a return value aside from the small network and processing
     * overhead of receiving a larger response. No Read Capacity Units are consumed.
     * <br>
     * <br>
     * Values returned are strongly consistent
     * <br>
     *
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *        after they were updated. For <code>UpdateItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        There is no additional cost associated with requesting a return value aside from the small network and
     *        processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *        <br>
     *        <br>
     *        Values returned are strongly consistent
     * @see ReturnValue
     */

    public void setReturnValues(ReturnValue returnValues) {
        this.returnValues = returnValues.toString();
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or after they
     * were updated. For <code>UpdateItem</code>, the valid values are:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     * operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem operation.
     * <br>
     * </li>
     * </ul>
     * <br>
     * There is no additional cost associated with requesting a return value aside from the small network and processing
     * overhead of receiving a larger response. No Read Capacity Units are consumed.
     * <br>
     * <br>
     * Values returned are strongly consistent
     * <br>
     *
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared either before or
     *        after they were updated. For <code>UpdateItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - Returns all of the attributes of the item, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_OLD</code> - Returns only the updated attributes, as they appeared before the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_NEW</code> - Returns all of the attributes of the item, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>UPDATED_NEW</code> - Returns only the updated attributes, as they appear after the UpdateItem
     *        operation.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        There is no additional cost associated with requesting a return value aside from the small network and
     *        processing overhead of receiving a larger response. No Read Capacity Units are consumed.
     *        <br>
     *        <br>
     *        Values returned are strongly consistent
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnValue
     */

    public UpdateItemRequest withReturnValues(ReturnValue returnValues) {
        setReturnValues(returnValues);
        return this;
    }

    /**
     * @param returnConsumedCapacity
     * @see ReturnConsumedCapacity
     */

    public void setReturnConsumedCapacity(String returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity;
    }

    /**
     * @return
     * @see ReturnConsumedCapacity
     */

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    /**
     * @param returnConsumedCapacity
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnConsumedCapacity
     */

    public UpdateItemRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
        setReturnConsumedCapacity(returnConsumedCapacity);
        return this;
    }

    /**
     * @param returnConsumedCapacity
     * @see ReturnConsumedCapacity
     */

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        this.returnConsumedCapacity = returnConsumedCapacity.toString();
    }

    /**
     * @param returnConsumedCapacity
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnConsumedCapacity
     */

    public UpdateItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        setReturnConsumedCapacity(returnConsumedCapacity);
        return this;
    }

    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     *
     * @param returnItemCollectionMetrics
     *        Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *        includes statistics about item collections, if any, that were modified during the operation are returned
     *        in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @see ReturnItemCollectionMetrics
     */

    public void setReturnItemCollectionMetrics(String returnItemCollectionMetrics) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics;
    }

    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     *
     * @return Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *         includes statistics about item collections, if any, that were modified during the operation are returned
     *         in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @see ReturnItemCollectionMetrics
     */

    public String getReturnItemCollectionMetrics() {
        return this.returnItemCollectionMetrics;
    }

    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     *
     * @param returnItemCollectionMetrics
     *        Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *        includes statistics about item collections, if any, that were modified during the operation are returned
     *        in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnItemCollectionMetrics
     */

    public UpdateItemRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics) {
        setReturnItemCollectionMetrics(returnItemCollectionMetrics);
        return this;
    }

    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     *
     * @param returnItemCollectionMetrics
     *        Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *        includes statistics about item collections, if any, that were modified during the operation are returned
     *        in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @see ReturnItemCollectionMetrics
     */

    public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics.toString();
    }

    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     *
     * @param returnItemCollectionMetrics
     *        Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *        includes statistics about item collections, if any, that were modified during the operation are returned
     *        in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnItemCollectionMetrics
     */

    public UpdateItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics) {
        setReturnItemCollectionMetrics(returnItemCollectionMetrics);
        return this;
    }

    /**
     * <br>
     * An expression that defines one or more attributes to be updated, the action to be performed on them, and new
     * value(s) for them.
     * <br>
     * <br>
     * The following action values are available for <code>UpdateExpression</code>.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already exist,
     * they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an attribute that
     * is of type Number. For example: <code>SET myNum = myNum + :val</code>
     * <br>
     * <br>
     * <code>SET</code> supports the following functions:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified path,
     * then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use this function
     * to avoid overwriting an attribute that may already be present in the item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can append
     * the new element to the start or the end of the list by reversing the order of the operands.
     * <br>
     * </li>
     * </ul>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>REMOVE</code> - Removes one or more attributes from an item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     * attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses <code>0</code> as the initial value.
     * <br>
     * <br>
     * Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value that
     * doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example, suppose that the
     * item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide to <code>ADD</code> the
     * number <code>3</code> to this attribute anyway. DynamoDB will create the <i>itemcount</i> attribute, set its
     * initial value to <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i>
     * attribute in the item, with a value of <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is added to
     * the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the <code>ADD</code>
     * action specified <code>[3]</code>, then the final attribute value is <code>[1,2,3]</code>. An error occurs if an
     * <code>ADD</code> action is specified for a set attribute and the attribute type specified does not match the
     * existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings.
     * <br>
     * </li>
     * </ul>
     * <important>
     * <br>
     * The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can only be
     * used on top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * <li>
     * <br>
     * <code>DELETE</code> - Deletes an element from a set.
     * <br>
     * <br>
     * If a set of values is specified, then those values are subtracted from the old set. For example, if the attribute
     * value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies <code>[a,c]</code>, then the
     * final attribute value is <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * <important>
     * <br>
     * The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be used on
     * top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * </ul>
     * <br>
     * You can have many actions in a single expression, such as the following:
     * <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     * <br>
     * <br>
     * For more information on update expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html">Modifying Items
     * and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param updateExpression
     *        An expression that defines one or more attributes to be updated, the action to be performed on them, and
     *        new value(s) for them.<br>
     *        <br>
     *        The following action values are available for <code>UpdateExpression</code>.
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already
     *        exist, they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an
     *        attribute that is of type Number. For example: <code>SET myNum = myNum + :val</code>
     *        <br>
     *        <br>
     *        <code>SET</code> supports the following functions:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified
     *        path, then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use
     *        this function to avoid overwriting an attribute that may already be present in the item.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can
     *        append the new element to the start or the end of the list by reversing the order of the operands.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        These function names are case-sensitive.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>REMOVE</code> - Removes one or more attributes from an item.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     *        attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then <code>Value</code>
     *        is mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is
     *        subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses <code>0</code> as the initial value.
     *        <br>
     *        <br>
     *        Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value
     *        that doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example,
     *        suppose that the item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide
     *        to <code>ADD</code> the number <code>3</code> to this attribute anyway. DynamoDB will create the
     *        <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add <code>3</code> to it.
     *        The result will be a new <i>itemcount</i> attribute in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is
     *        added to the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the
     *        <code>ADD</code> action specified <code>[3]</code>, then the final attribute value is <code>[1,2,3]</code>
     *        . An error occurs if an <code>ADD</code> action is specified for a set attribute and the attribute type
     *        specified does not match the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings.
     *        <br>
     *        </li>
     *        </ul>
     *        <important>
     *        <br>
     *        The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can
     *        only be used on top-level attributes, not nested attributes.
     *        <br>
     *        </important></li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Deletes an element from a set.
     *        <br>
     *        <br>
     *        If a set of values is specified, then those values are subtracted from the old set. For example, if the
     *        attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies
     *        <code>[a,c]</code>, then the final attribute value is <code>[b]</code>. Specifying an empty set is an
     *        error.
     *        <br>
     *        <important>
     *        <br>
     *        The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be
     *        used on top-level attributes, not nested attributes.
     *        <br>
     *        </important></li>
     *        </ul>
     *        <br>
     *        You can have many actions in a single expression, such as the following:
     *        <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     *        <br>
     *        <br>
     *        For more information on update expressions, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html"
     *        >Modifying Items and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setUpdateExpression(String updateExpression) {
        this.updateExpression = updateExpression;
    }

    /**
     * <br>
     * An expression that defines one or more attributes to be updated, the action to be performed on them, and new
     * value(s) for them.
     * <br>
     * <br>
     * The following action values are available for <code>UpdateExpression</code>.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already exist,
     * they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an attribute that
     * is of type Number. For example: <code>SET myNum = myNum + :val</code>
     * <br>
     * <br>
     * <code>SET</code> supports the following functions:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified path,
     * then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use this function
     * to avoid overwriting an attribute that may already be present in the item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can append
     * the new element to the start or the end of the list by reversing the order of the operands.
     * <br>
     * </li>
     * </ul>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>REMOVE</code> - Removes one or more attributes from an item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     * attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses <code>0</code> as the initial value.
     * <br>
     * <br>
     * Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value that
     * doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example, suppose that the
     * item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide to <code>ADD</code> the
     * number <code>3</code> to this attribute anyway. DynamoDB will create the <i>itemcount</i> attribute, set its
     * initial value to <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i>
     * attribute in the item, with a value of <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is added to
     * the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the <code>ADD</code>
     * action specified <code>[3]</code>, then the final attribute value is <code>[1,2,3]</code>. An error occurs if an
     * <code>ADD</code> action is specified for a set attribute and the attribute type specified does not match the
     * existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings.
     * <br>
     * </li>
     * </ul>
     * <important>
     * <br>
     * The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can only be
     * used on top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * <li>
     * <br>
     * <code>DELETE</code> - Deletes an element from a set.
     * <br>
     * <br>
     * If a set of values is specified, then those values are subtracted from the old set. For example, if the attribute
     * value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies <code>[a,c]</code>, then the
     * final attribute value is <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * <important>
     * <br>
     * The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be used on
     * top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * </ul>
     * <br>
     * You can have many actions in a single expression, such as the following:
     * <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     * <br>
     * <br>
     * For more information on update expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html">Modifying Items
     * and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return An expression that defines one or more attributes to be updated, the action to be performed on them, and
     *         new value(s) for them.<br>
     *         <br>
     *         The following action values are available for <code>UpdateExpression</code>.
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already
     *         exist, they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an
     *         attribute that is of type Number. For example: <code>SET myNum = myNum + :val</code>
     *         <br>
     *         <br>
     *         <code>SET</code> supports the following functions:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified
     *         path, then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use
     *         this function to avoid overwriting an attribute that may already be present in the item.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can
     *         append the new element to the start or the end of the list by reversing the order of the operands.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         These function names are case-sensitive.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>REMOVE</code> - Removes one or more attributes from an item.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     *         attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         If the existing attribute is a number, and if <code>Value</code> is also a number, then
     *         <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *         number, then it is subtracted from the existing attribute.
     *         <br>
     *         <note>
     *         <br>
     *         If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist
     *         before the update, DynamoDB uses <code>0</code> as the initial value.
     *         <br>
     *         <br>
     *         Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value
     *         that doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example,
     *         suppose that the item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide
     *         to <code>ADD</code> the number <code>3</code> to this attribute anyway. DynamoDB will create the
     *         <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add <code>3</code> to
     *         it. The result will be a new <i>itemcount</i> attribute in the item, with a value of <code>3</code>.
     *         <br>
     *         </note></li>
     *         <li>
     *         <br>
     *         If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is
     *         added to the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the
     *         <code>ADD</code> action specified <code>[3]</code>, then the final attribute value is
     *         <code>[1,2,3]</code>. An error occurs if an <code>ADD</code> action is specified for a set attribute and
     *         the attribute type specified does not match the existing set type.
     *         <br>
     *         <br>
     *         Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *         strings, the <code>Value</code> must also be a set of strings.
     *         <br>
     *         </li>
     *         </ul>
     *         <important>
     *         <br>
     *         The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can
     *         only be used on top-level attributes, not nested attributes.
     *         <br>
     *         </important></li>
     *         <li>
     *         <br>
     *         <code>DELETE</code> - Deletes an element from a set.
     *         <br>
     *         <br>
     *         If a set of values is specified, then those values are subtracted from the old set. For example, if the
     *         attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies
     *         <code>[a,c]</code>, then the final attribute value is <code>[b]</code>. Specifying an empty set is an
     *         error.
     *         <br>
     *         <important>
     *         <br>
     *         The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be
     *         used on top-level attributes, not nested attributes.
     *         <br>
     *         </important></li>
     *         </ul>
     *         <br>
     *         You can have many actions in a single expression, such as the following:
     *         <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     *         <br>
     *         <br>
     *         For more information on update expressions, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html"
     *         >Modifying Items and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public String getUpdateExpression() {
        return this.updateExpression;
    }

    /**
     * <br>
     * An expression that defines one or more attributes to be updated, the action to be performed on them, and new
     * value(s) for them.
     * <br>
     * <br>
     * The following action values are available for <code>UpdateExpression</code>.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already exist,
     * they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an attribute that
     * is of type Number. For example: <code>SET myNum = myNum + :val</code>
     * <br>
     * <br>
     * <code>SET</code> supports the following functions:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified path,
     * then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use this function
     * to avoid overwriting an attribute that may already be present in the item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can append
     * the new element to the start or the end of the list by reversing the order of the operands.
     * <br>
     * </li>
     * </ul>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>REMOVE</code> - Removes one or more attributes from an item.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     * attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses <code>0</code> as the initial value.
     * <br>
     * <br>
     * Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value that
     * doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example, suppose that the
     * item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide to <code>ADD</code> the
     * number <code>3</code> to this attribute anyway. DynamoDB will create the <i>itemcount</i> attribute, set its
     * initial value to <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i>
     * attribute in the item, with a value of <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is added to
     * the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the <code>ADD</code>
     * action specified <code>[3]</code>, then the final attribute value is <code>[1,2,3]</code>. An error occurs if an
     * <code>ADD</code> action is specified for a set attribute and the attribute type specified does not match the
     * existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings.
     * <br>
     * </li>
     * </ul>
     * <important>
     * <br>
     * The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can only be
     * used on top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * <li>
     * <br>
     * <code>DELETE</code> - Deletes an element from a set.
     * <br>
     * <br>
     * If a set of values is specified, then those values are subtracted from the old set. For example, if the attribute
     * value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies <code>[a,c]</code>, then the
     * final attribute value is <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * <important>
     * <br>
     * The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be used on
     * top-level attributes, not nested attributes.
     * <br>
     * </important></li>
     * </ul>
     * <br>
     * You can have many actions in a single expression, such as the following:
     * <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     * <br>
     * <br>
     * For more information on update expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html">Modifying Items
     * and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param updateExpression
     *        An expression that defines one or more attributes to be updated, the action to be performed on them, and
     *        new value(s) for them.<br>
     *        <br>
     *        The following action values are available for <code>UpdateExpression</code>.
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>SET</code> - Adds one or more attributes and values to an item. If any of these attribute already
     *        exist, they are replaced by the new values. You can also use <code>SET</code> to add or subtract from an
     *        attribute that is of type Number. For example: <code>SET myNum = myNum + :val</code>
     *        <br>
     *        <br>
     *        <code>SET</code> supports the following functions:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>if_not_exists (path, operand)</code> - if the item does not contain an attribute at the specified
     *        path, then <code>if_not_exists</code> evaluates to operand; otherwise, it evaluates to path. You can use
     *        this function to avoid overwriting an attribute that may already be present in the item.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>list_append (operand, operand)</code> - evaluates to a list with a new element added to it. You can
     *        append the new element to the start or the end of the list by reversing the order of the operands.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        These function names are case-sensitive.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>REMOVE</code> - Removes one or more attributes from an item.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - Adds the specified value to the item, if the attribute does not already exist. If the
     *        attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then <code>Value</code>
     *        is mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is
     *        subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses <code>0</code> as the initial value.
     *        <br>
     *        <br>
     *        Similarly, if you use <code>ADD</code> for an existing item to increment or decrement an attribute value
     *        that doesn't exist before the update, DynamoDB uses <code>0</code> as the initial value. For example,
     *        suppose that the item you want to update doesn't have an attribute named <i>itemcount</i>, but you decide
     *        to <code>ADD</code> the number <code>3</code> to this attribute anyway. DynamoDB will create the
     *        <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add <code>3</code> to it.
     *        The result will be a new <i>itemcount</i> attribute in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set and if <code>Value</code> is also a set, then <code>Value</code> is
     *        added to the existing set. For example, if the attribute value is the set <code>[1,2]</code>, and the
     *        <code>ADD</code> action specified <code>[3]</code>, then the final attribute value is <code>[1,2,3]</code>
     *        . An error occurs if an <code>ADD</code> action is specified for a set attribute and the attribute type
     *        specified does not match the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings.
     *        <br>
     *        </li>
     *        </ul>
     *        <important>
     *        <br>
     *        The <code>ADD</code> action only supports Number and set data types. In addition, <code>ADD</code> can
     *        only be used on top-level attributes, not nested attributes.
     *        <br>
     *        </important></li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Deletes an element from a set.
     *        <br>
     *        <br>
     *        If a set of values is specified, then those values are subtracted from the old set. For example, if the
     *        attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specifies
     *        <code>[a,c]</code>, then the final attribute value is <code>[b]</code>. Specifying an empty set is an
     *        error.
     *        <br>
     *        <important>
     *        <br>
     *        The <code>DELETE</code> action only supports set data types. In addition, <code>DELETE</code> can only be
     *        used on top-level attributes, not nested attributes.
     *        <br>
     *        </important></li>
     *        </ul>
     *        <br>
     *        You can have many actions in a single expression, such as the following:
     *        <code>SET a=:value1, b=:value2 DELETE :value3, :value4, :value5</code>
     *        <br>
     *        <br>
     *        For more information on update expressions, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.Modifying.html"
     *        >Modifying Items and Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withUpdateExpression(String updateExpression) {
        setUpdateExpression(updateExpression);
        return this;
    }

    /**
     * <br>
     * A condition that must be satisfied in order for a conditional update to succeed.
     * <br>
     * <br>
     * An expression can contain any of the following:
     * <br>
     * <ul>
     * <li>
     * <br>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     * <br>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     * <br>
     * </li>
     * <li>
     * <br>
     * Logical operators: <code>AND | OR | NOT</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionExpression
     *        A condition that must be satisfied in order for a conditional update to succeed.<br>
     *        <br>
     *        An expression can contain any of the following:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        Functions:
     *        <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     *        <br>
     *        <br>
     *        These function names are case-sensitive.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        Logical operators: <code>AND | OR | NOT</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        For more information on condition expressions, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    /**
     * <br>
     * A condition that must be satisfied in order for a conditional update to succeed.
     * <br>
     * <br>
     * An expression can contain any of the following:
     * <br>
     * <ul>
     * <li>
     * <br>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     * <br>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     * <br>
     * </li>
     * <li>
     * <br>
     * Logical operators: <code>AND | OR | NOT</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return A condition that must be satisfied in order for a conditional update to succeed.<br>
     *         <br>
     *         An expression can contain any of the following:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         Functions:
     *         <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     *         <br>
     *         <br>
     *         These function names are case-sensitive.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         Logical operators: <code>AND | OR | NOT</code>
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         For more information on condition expressions, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *         >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public String getConditionExpression() {
        return this.conditionExpression;
    }

    /**
     * <br>
     * A condition that must be satisfied in order for a conditional update to succeed.
     * <br>
     * <br>
     * An expression can contain any of the following:
     * <br>
     * <ul>
     * <li>
     * <br>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     * <br>
     * <br>
     * These function names are case-sensitive.
     * <br>
     * </li>
     * <li>
     * <br>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     * <br>
     * </li>
     * <li>
     * <br>
     * Logical operators: <code>AND | OR | NOT</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionExpression
     *        A condition that must be satisfied in order for a conditional update to succeed.<br>
     *        <br>
     *        An expression can contain any of the following:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        Functions:
     *        <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code>
     *        <br>
     *        <br>
     *        These function names are case-sensitive.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code>
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        Logical operators: <code>AND | OR | NOT</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        For more information on condition expressions, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withConditionExpression(String conditionExpression) {
        setConditionExpression(conditionExpression);
        return this;
    }

    /**
     * <br>
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * <br>
     * </li>
     * <li>
     * <br>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * <br>
     * </li>
     * <li>
     * <br>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Percentile</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>{"#P":"Percentile"}</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * You could then use this substitution in an expression, as in this example:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#P = :val</code>
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * <br>
     * </note>
     * <br>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return One or more substitution tokens for attribute names in an expression. The following are some use cases
     *         for using <code>ExpressionAttributeNames</code>:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         To access an attribute whose name conflicts with a DynamoDB reserved word.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         To create a placeholder for repeating occurrences of an attribute name in an expression.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         To prevent special characters in an attribute name from being misinterpreted in an expression.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the
     *         following attribute name:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>Percentile</code>
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         The name of this attribute conflicts with a reserved word, so it cannot be used directly in an
     *         expression. (For the complete list of reserved words, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *         Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the
     *         following for <code>ExpressionAttributeNames</code>:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>{"#P":"Percentile"}</code>
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         You could then use this substitution in an expression, as in this example:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>#P = :val</code>
     *         <br>
     *         </li>
     *         </ul>
     *         <note>
     *         <br>
     *         Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are
     *         placeholders for the actual value at runtime.
     *         <br>
     *         </note>
     *         <br>
     *         For more information on expression attribute names, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *         >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, String> getExpressionAttributeNames() {
        return expressionAttributeNames;
    }

    /**
     * <br>
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * <br>
     * </li>
     * <li>
     * <br>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * <br>
     * </li>
     * <li>
     * <br>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Percentile</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>{"#P":"Percentile"}</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * You could then use this substitution in an expression, as in this example:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#P = :val</code>
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * <br>
     * </note>
     * <br>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param expressionAttributeNames
     *        One or more substitution tokens for attribute names in an expression. The following are some use cases for
     *        using <code>ExpressionAttributeNames</code>:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        To access an attribute whose name conflicts with a DynamoDB reserved word.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        To create a placeholder for repeating occurrences of an attribute name in an expression.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        To prevent special characters in an attribute name from being misinterpreted in an expression.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the
     *        following attribute name:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Percentile</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression.
     *        (For the complete list of reserved words, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *        Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the
     *        following for <code>ExpressionAttributeNames</code>:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>{"#P":"Percentile"}</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        You could then use this substitution in an expression, as in this example:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>#P = :val</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are
     *        placeholders for the actual value at runtime.
     *        <br>
     *        </note>
     *        <br>
     *        For more information on expression attribute names, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *        >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        this.expressionAttributeNames = expressionAttributeNames;
    }

    /**
     * <br>
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * <br>
     * </li>
     * <li>
     * <br>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * <br>
     * </li>
     * <li>
     * <br>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Percentile</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>{"#P":"Percentile"}</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * You could then use this substitution in an expression, as in this example:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#P = :val</code>
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * <br>
     * </note>
     * <br>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param expressionAttributeNames
     *        One or more substitution tokens for attribute names in an expression. The following are some use cases for
     *        using <code>ExpressionAttributeNames</code>:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        To access an attribute whose name conflicts with a DynamoDB reserved word.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        To create a placeholder for repeating occurrences of an attribute name in an expression.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        To prevent special characters in an attribute name from being misinterpreted in an expression.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the
     *        following attribute name:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Percentile</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression.
     *        (For the complete list of reserved words, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *        Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the
     *        following for <code>ExpressionAttributeNames</code>:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>{"#P":"Percentile"}</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        You could then use this substitution in an expression, as in this example:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>#P = :val</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are
     *        placeholders for the actual value at runtime.
     *        <br>
     *        </note>
     *        <br>
     *        For more information on expression attribute names, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *        >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    public UpdateItemRequest addExpressionAttributeNamesEntry(String key, String value) {
        if (null == this.expressionAttributeNames) {
            this.expressionAttributeNames = new java.util.HashMap<String, String>();
        }
        if (this.expressionAttributeNames.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.expressionAttributeNames.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExpressionAttributeNames.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    /**
     * <br>
     * One or more values that can be substituted in an expression.
     * <br>
     * <br>
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <br>
     * <br>
     * <code>Available | Backordered | Discontinued</code>
     * <br>
     * <br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <br>
     * <br>
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <br>
     * <br>
     * You could then use these values in an expression, such as this:
     * <br>
     * <br>
     * <code>ProductStatus IN (:avail, :back, :disc)</code>
     * <br>
     * <br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return One or more values that can be substituted in an expression.<br>
     *         <br>
     *         Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example,
     *         suppose that you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the
     *         following:
     *         <br>
     *         <br>
     *         <code>Available | Backordered | Discontinued</code>
     *         <br>
     *         <br>
     *         You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     *         <br>
     *         <br>
     *         <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     *         <br>
     *         <br>
     *         You could then use these values in an expression, such as this:
     *         <br>
     *         <br>
     *         <code>ProductStatus IN (:avail, :back, :disc)</code>
     *         <br>
     *         <br>
     *         For more information on expression attribute values, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *         >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, AttributeValue> getExpressionAttributeValues() {
        return expressionAttributeValues;
    }

    /**
     * <br>
     * One or more values that can be substituted in an expression.
     * <br>
     * <br>
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <br>
     * <br>
     * <code>Available | Backordered | Discontinued</code>
     * <br>
     * <br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <br>
     * <br>
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <br>
     * <br>
     * You could then use these values in an expression, such as this:
     * <br>
     * <br>
     * <code>ProductStatus IN (:avail, :back, :disc)</code>
     * <br>
     * <br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param expressionAttributeValues
     *        One or more values that can be substituted in an expression.<br>
     *        <br>
     *        Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example,
     *        suppose that you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the
     *        following:
     *        <br>
     *        <br>
     *        <code>Available | Backordered | Discontinued</code>
     *        <br>
     *        <br>
     *        You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     *        <br>
     *        <br>
     *        <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     *        <br>
     *        <br>
     *        You could then use these values in an expression, such as this:
     *        <br>
     *        <br>
     *        <code>ProductStatus IN (:avail, :back, :disc)</code>
     *        <br>
     *        <br>
     *        For more information on expression attribute values, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        this.expressionAttributeValues = expressionAttributeValues;
    }

    /**
     * <br>
     * One or more values that can be substituted in an expression.
     * <br>
     * <br>
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <br>
     * <br>
     * <code>Available | Backordered | Discontinued</code>
     * <br>
     * <br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <br>
     * <br>
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     * <br>
     * <br>
     * You could then use these values in an expression, such as this:
     * <br>
     * <br>
     * <code>ProductStatus IN (:avail, :back, :disc)</code>
     * <br>
     * <br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param expressionAttributeValues
     *        One or more values that can be substituted in an expression.<br>
     *        <br>
     *        Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example,
     *        suppose that you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the
     *        following:
     *        <br>
     *        <br>
     *        <code>Available | Backordered | Discontinued</code>
     *        <br>
     *        <br>
     *        You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     *        <br>
     *        <br>
     *        <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code>
     *        <br>
     *        <br>
     *        You could then use these values in an expression, such as this:
     *        <br>
     *        <br>
     *        <code>ProductStatus IN (:avail, :back, :disc)</code>
     *        <br>
     *        <br>
     *        For more information on expression attribute values, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest withExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    public UpdateItemRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
        if (null == this.expressionAttributeValues) {
            this.expressionAttributeValues = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.expressionAttributeValues.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.expressionAttributeValues.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExpressionAttributeValues.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateItemRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    /**
     * Set the hash and range key attributes of the item.
     * <br>
     * For a hash-only table, you only need to provide the hash attribute. For a hash-and-range table, you must provide
     * both.
     *
     * @param hashKey
     *        a map entry including the name and value of the primary hash key.
     * @param rangeKey
     *        a map entry including the name and value of the primary range key, or null if it is a hash-only table.
     */
    public void setKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        java.util.HashMap<String, AttributeValue> key = new java.util.HashMap<String, AttributeValue>();
        if (hashKey != null) {
            key.put(hashKey.getKey(), hashKey.getValue());
        } else {
            throw new IllegalArgumentException("hashKey must be non-null object.");
        }
        if (rangeKey != null) {
            key.put(rangeKey.getKey(), rangeKey.getValue());
        }
        setKey(key);
    }

    /**
     * Set the hash and range key attributes of the item.
     * <br>
     * For a hash-only table, you only need to provide the hash attribute. For a hash-and-range table, you must provide
     * both.
     * <br>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param hashKey
     *        a map entry including the name and value of the primary hash key.
     * @param rangeKey
     *        a map entry including the name and value of the primary range key, or null if it is a hash-only table.
     */
    public UpdateItemRequest withKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        setKey(hashKey, rangeKey);
        return this;
    }
}
