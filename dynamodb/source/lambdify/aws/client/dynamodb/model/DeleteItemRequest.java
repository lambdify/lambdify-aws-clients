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
 * Represents the input of a <code>DeleteItem</code> operation.
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/DeleteItem" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class DeleteItemRequest implements Serializable {

    /**
     * The name of the table from which to delete the item.
     */
    @JsonProperty("TableName")
    private String tableName;
    /**
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * delete.
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     */
    @JsonProperty("Key")
    private java.util.Map<String, AttributeValue> key;
    /**
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    @JsonProperty("Expected")
    private java.util.Map<String, ExpectedAttributeValue> expected;
    /**
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    @JsonProperty("ConditionalOperator")
    private String conditionalOperator;
    /**
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were deleted.
     * For <code>DeleteItem</code>, the valid values are:
     * <ul>
     * <li>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * </li>
     * <li>
     * <code>ALL_OLD</code> - The content of the old item is returned.
     * </li>
     * </ul>
     * <note>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>DeleteItem</code><br><br>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * </note>
     */
    @JsonProperty("ReturnValues")
    private String returnValues;

    @JsonProperty("ReturnConsumedCapacity")
    private String returnConsumedCapacity;
    /**
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     */
    @JsonProperty("ReturnItemCollectionMetrics")
    private String returnItemCollectionMetrics;
    /**
     * A condition that must be satisfied in order for a conditional <code>DeleteItem</code> to succeed.
     * An expression can contain any of the following:
     * <ul>
     * <li>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     * These function names are case-sensitive.
     * </li>
     * <li>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     * </li>
     * <li>
     * Logical operators: <code>AND | OR | NOT</code><br><br>
     * </li>
     * </ul>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    @JsonProperty("ConditionExpression")
    private String conditionExpression;
    /**
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * </li>
     * <li>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * </li>
     * <li>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * </li>
     * </ul>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <ul>
     * <li>
     * <code>Percentile</code><br><br>
     * </li>
     * </ul>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * <code>{"#P":"Percentile"}</code><br><br>
     * </li>
     * </ul>
     * You could then use this substitution in an expression, as in this example:
     * <ul>
     * <li>
     * <code>#P = :val</code><br><br>
     * </li>
     * </ul>
     * <note>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * </note>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    @JsonProperty("ExpressionAttributeNames")
    private java.util.Map<String, String> expressionAttributeNames;
    /**
     * One or more values that can be substituted in an expression.
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <code>Available | Backordered | Discontinued</code><br><br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     * You could then use these values in an expression, such as this:
     * <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    @JsonProperty("ExpressionAttributeValues")
    private java.util.Map<String, AttributeValue> expressionAttributeValues;

    /**
     * Default constructor for DeleteItemRequest object. Callers should use the setter or fluent setter (with...)
     * methods to initialize the object after creating it.
     */
    public DeleteItemRequest() {
    }

    /**
     * Constructs a new DeleteItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table from which to delete the item.
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        to delete.
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     */
    public DeleteItemRequest(String tableName, java.util.Map<String, AttributeValue> key) {
        setTableName(tableName);
        setKey(key);
    }

    /**
     * Constructs a new DeleteItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table from which to delete the item.
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        to delete.
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        deleted. For <code>DeleteItem</code>, the valid values are:
     *        <ul>
     *        <li>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        </li>
     *        <li>
     *        <code>ALL_OLD</code> - The content of the old item is returned.
     *        </li>
     *        </ul>
     *        <note>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code><br><br>
     *        .
     */
    public DeleteItemRequest(String tableName, java.util.Map<String, AttributeValue> key, String returnValues) {
        setTableName(tableName);
        setKey(key);
        setReturnValues(returnValues);
    }

    /**
     * Constructs a new DeleteItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table from which to delete the item.
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        deleted. For <code>DeleteItem</code>, the valid values are:
     *        <ul>
     *        <li>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        </li>
     *        <li>
     *        <code>ALL_OLD</code> - The content of the old item is returned.
     *        </li>
     *        </ul>
     *        <note>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code><br><br>
     *        .
     */
    public DeleteItemRequest(String tableName, java.util.Map<String, AttributeValue> key, ReturnValue returnValues) {
        setTableName(tableName);
        setKey(key);
        setReturnValues(returnValues.toString());
    }

    /**
     * The name of the table from which to delete the item.
     * 
     * @param tableName
     *        The name of the table from which to delete the item.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * The name of the table from which to delete the item.
     * 
     * @return The name of the table from which to delete the item.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * The name of the table from which to delete the item.
     * 
     * @param tableName
     *        The name of the table from which to delete the item.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteItemRequest withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * delete.
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * 
     * @return A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *         For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *         only need to provide a value for the partition key. For a composite primary key, you must provide values
     *         for both the partition key and the sort key.
     */

    public java.util.Map<String, AttributeValue> getKey() {
        return key;
    }

    /**
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * delete.
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * 
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     */

    public void setKey(java.util.Map<String, AttributeValue> key) {
        this.key = key;
    }

    /**
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * delete.
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * 
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteItemRequest withKey(java.util.Map<String, AttributeValue> key) {
        setKey(key);
        return this;
    }

    public DeleteItemRequest addKeyEntry(String key, AttributeValue value) {
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

    public DeleteItemRequest clearKeyEntries() {
        this.key = null;
        return this;
    }

    /**
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
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
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
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
     * This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     * >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param expected
     *        This is a legacy parameter. Use <code>ConditionExpresssion</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.Expected.html"
     *        >Expected</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteItemRequest withExpected(java.util.Map<String, ExpectedAttributeValue> expected) {
        setExpected(expected);
        return this;
    }

    public DeleteItemRequest addExpectedEntry(String key, ExpectedAttributeValue value) {
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

    public DeleteItemRequest clearExpectedEntries() {
        this.expected = null;
        return this;
    }

    /**
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
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
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
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
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ConditionalOperator
     */

    public DeleteItemRequest withConditionalOperator(String conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
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
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ConditionalOperator
     */

    public DeleteItemRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were deleted.
     * For <code>DeleteItem</code>, the valid values are:
     * <ul>
     * <li>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * </li>
     * <li>
     * <code>ALL_OLD</code> - The content of the old item is returned.
     * </li>
     * </ul>
     * <note>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>DeleteItem</code><br><br>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        <ul>
     *        <li>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        </li>
     *        <li>
     *        <code>ALL_OLD</code> - The content of the old item is returned.
     *        </li>
     *        </ul>
     *        <note>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code><br><br>
     *        .
     * @see ReturnValue
     */

    public void setReturnValues(String returnValues) {
        this.returnValues = returnValues;
    }

    /**
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were deleted.
     * For <code>DeleteItem</code>, the valid values are:
     * <ul>
     * <li>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * </li>
     * <li>
     * <code>ALL_OLD</code> - The content of the old item is returned.
     * </li>
     * </ul>
     * <note>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>DeleteItem</code><br><br>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * </note>
     * 
     * @return Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *         <ul>
     *         <li>
     *         <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *         then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *         </li>
     *         <li>
     *         <code>ALL_OLD</code> - The content of the old item is returned.
     *         </li>
     *         </ul>
     *         <note>
     *         The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *         <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or
     *         <code>ALL_OLD</code>.
     * @see ReturnValue
     */

    public String getReturnValues() {
        return this.returnValues;
    }

    /**
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were deleted.
     * For <code>DeleteItem</code>, the valid values are:
     * <ul>
     * <li>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * </li>
     * <li>
     * <code>ALL_OLD</code> - The content of the old item is returned.
     * </li>
     * </ul>
     * <note>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>DeleteItem</code><br><br>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        <ul>
     *        <li>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        </li>
     *        <li>
     *        <code>ALL_OLD</code> - The content of the old item is returned.
     *        </li>
     *        </ul>
     *        <note>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code><br><br>
     *        .
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnValue
     */

    public DeleteItemRequest withReturnValues(String returnValues) {
        setReturnValues(returnValues);
        return this;
    }

    /**
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were deleted.
     * For <code>DeleteItem</code>, the valid values are:
     * <ul>
     * <li>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * </li>
     * <li>
     * <code>ALL_OLD</code> - The content of the old item is returned.
     * </li>
     * </ul>
     * <note>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>DeleteItem</code><br><br>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        <ul>
     *        <li>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        </li>
     *        <li>
     *        <code>ALL_OLD</code> - The content of the old item is returned.
     *        </li>
     *        </ul>
     *        <note>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code><br><br>
     *        .
     * @see ReturnValue
     */

    public void setReturnValues(ReturnValue returnValues) {
        this.returnValues = returnValues.toString();
    }

    /**
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were deleted.
     * For <code>DeleteItem</code>, the valid values are:
     * <ul>
     * <li>
     * <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>, then
     * nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     * </li>
     * <li>
     * <code>ALL_OLD</code> - The content of the old item is returned.
     * </li>
     * </ul>
     * <note>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>DeleteItem</code><br><br>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        <ul>
     *        <li>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        </li>
     *        <li>
     *        <code>ALL_OLD</code> - The content of the old item is returned.
     *        </li>
     *        </ul>
     *        <note>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>DeleteItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code><br><br>
     *        .
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnValue
     */

    public DeleteItemRequest withReturnValues(ReturnValue returnValues) {
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

    public DeleteItemRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
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

    public DeleteItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        setReturnConsumedCapacity(returnConsumedCapacity);
        return this;
    }

    /**
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
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
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
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
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * 
     * @param returnItemCollectionMetrics
     *        Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *        includes statistics about item collections, if any, that were modified during the operation are returned
     *        in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnItemCollectionMetrics
     */

    public DeleteItemRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics) {
        setReturnItemCollectionMetrics(returnItemCollectionMetrics);
        return this;
    }

    /**
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
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
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * 
     * @param returnItemCollectionMetrics
     *        Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response
     *        includes statistics about item collections, if any, that were modified during the operation are returned
     *        in the response. If set to <code>NONE</code> (the default), no statistics are returned.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnItemCollectionMetrics
     */

    public DeleteItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics) {
        setReturnItemCollectionMetrics(returnItemCollectionMetrics);
        return this;
    }

    /**
     * A condition that must be satisfied in order for a conditional <code>DeleteItem</code> to succeed.
     * An expression can contain any of the following:
     * <ul>
     * <li>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     * These function names are case-sensitive.
     * </li>
     * <li>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     * </li>
     * <li>
     * Logical operators: <code>AND | OR | NOT</code><br><br>
     * </li>
     * </ul>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param conditionExpression
     *        An expression can contain any of the following:
     *        <ul>
     *        <li>
     *        Functions:
     *        <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     *        These function names are case-sensitive.
     *        </li>
     *        <li>
     *        Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     *        </li>
     *        <li>
     *        Logical operators: <code>AND | OR | NOT</code><br><br>
     *        </li>
     *        </ul>
     *        For more information on condition expressions, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    /**
     * A condition that must be satisfied in order for a conditional <code>DeleteItem</code> to succeed.
     * An expression can contain any of the following:
     * <ul>
     * <li>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     * These function names are case-sensitive.
     * </li>
     * <li>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     * </li>
     * <li>
     * Logical operators: <code>AND | OR | NOT</code><br><br>
     * </li>
     * </ul>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     *         An expression can contain any of the following:
     *         <ul>
     *         <li>
     *         Functions:
     *         <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     *         These function names are case-sensitive.
     *         </li>
     *         <li>
     *         Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     *         </li>
     *         <li>
     *         Logical operators: <code>AND | OR | NOT</code><br><br>
     *         </li>
     *         </ul>
     *         For more information on condition expressions, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *         >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public String getConditionExpression() {
        return this.conditionExpression;
    }

    /**
     * A condition that must be satisfied in order for a conditional <code>DeleteItem</code> to succeed.
     * An expression can contain any of the following:
     * <ul>
     * <li>
     * Functions: <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     * These function names are case-sensitive.
     * </li>
     * <li>
     * Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     * </li>
     * <li>
     * Logical operators: <code>AND | OR | NOT</code><br><br>
     * </li>
     * </ul>
     * For more information on condition expressions, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param conditionExpression
     *        An expression can contain any of the following:
     *        <ul>
     *        <li>
     *        Functions:
     *        <code>attribute_exists | attribute_not_exists | attribute_type | contains | begins_with | size</code><br><br>
     *        These function names are case-sensitive.
     *        </li>
     *        <li>
     *        Comparison operators: <code>= | &lt;&gt; | &lt; | &gt; | &lt;= | &gt;= | BETWEEN | IN </code><br><br>
     *        </li>
     *        <li>
     *        Logical operators: <code>AND | OR | NOT</code><br><br>
     *        </li>
     *        </ul>
     *        For more information on condition expressions, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteItemRequest withConditionExpression(String conditionExpression) {
        setConditionExpression(conditionExpression);
        return this;
    }

    /**
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * </li>
     * <li>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * </li>
     * <li>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * </li>
     * </ul>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <ul>
     * <li>
     * <code>Percentile</code><br><br>
     * </li>
     * </ul>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * <code>{"#P":"Percentile"}</code><br><br>
     * </li>
     * </ul>
     * You could then use this substitution in an expression, as in this example:
     * <ul>
     * <li>
     * <code>#P = :val</code><br><br>
     * </li>
     * </ul>
     * <note>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * </note>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @return One or more substitution tokens for attribute names in an expression. The following are some use cases
     *         <ul>
     *         <li>
     *         To access an attribute whose name conflicts with a DynamoDB reserved word.
     *         </li>
     *         <li>
     *         To create a placeholder for repeating occurrences of an attribute name in an expression.
     *         </li>
     *         <li>
     *         To prevent special characters in an attribute name from being misinterpreted in an expression.
     *         </li>
     *         </ul>
     *         Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the
     *         following attribute name:
     *         <ul>
     *         <li>
     *         <code>Percentile</code><br><br>
     *         </li>
     *         </ul>
     *         The name of this attribute conflicts with a reserved word, so it cannot be used directly in an
     *         expression. (For the complete list of reserved words, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *         Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the
     *         following for <code>ExpressionAttributeNames</code>:
     *         <ul>
     *         <li>
     *         <code>{"#P":"Percentile"}</code><br><br>
     *         </li>
     *         </ul>
     *         You could then use this substitution in an expression, as in this example:
     *         <ul>
     *         <li>
     *         <code>#P = :val</code><br><br>
     *         </li>
     *         </ul>
     *         <note>
     *         Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are
     *         placeholders for the actual value at runtime.
     *         </note>
     *         For more information on expression attribute names, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *         >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, String> getExpressionAttributeNames() {
        return expressionAttributeNames;
    }

    /**
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * </li>
     * <li>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * </li>
     * <li>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * </li>
     * </ul>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <ul>
     * <li>
     * <code>Percentile</code><br><br>
     * </li>
     * </ul>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * <code>{"#P":"Percentile"}</code><br><br>
     * </li>
     * </ul>
     * You could then use this substitution in an expression, as in this example:
     * <ul>
     * <li>
     * <code>#P = :val</code><br><br>
     * </li>
     * </ul>
     * <note>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * </note>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param expressionAttributeNames
     *        One or more substitution tokens for attribute names in an expression. The following are some use cases for
     *        <ul>
     *        <li>
     *        To access an attribute whose name conflicts with a DynamoDB reserved word.
     *        </li>
     *        <li>
     *        To create a placeholder for repeating occurrences of an attribute name in an expression.
     *        </li>
     *        <li>
     *        To prevent special characters in an attribute name from being misinterpreted in an expression.
     *        </li>
     *        </ul>
     *        Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the
     *        following attribute name:
     *        <ul>
     *        <li>
     *        <code>Percentile</code><br><br>
     *        </li>
     *        </ul>
     *        The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression.
     *        (For the complete list of reserved words, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *        Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the
     *        following for <code>ExpressionAttributeNames</code>:
     *        <ul>
     *        <li>
     *        <code>{"#P":"Percentile"}</code><br><br>
     *        </li>
     *        </ul>
     *        You could then use this substitution in an expression, as in this example:
     *        <ul>
     *        <li>
     *        <code>#P = :val</code><br><br>
     *        </li>
     *        </ul>
     *        <note>
     *        Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are
     *        placeholders for the actual value at runtime.
     *        </note>
     *        For more information on expression attribute names, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *        >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        this.expressionAttributeNames = expressionAttributeNames;
    }

    /**
     * One or more substitution tokens for attribute names in an expression. The following are some use cases for using
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * To access an attribute whose name conflicts with a DynamoDB reserved word.
     * </li>
     * <li>
     * To create a placeholder for repeating occurrences of an attribute name in an expression.
     * </li>
     * <li>
     * To prevent special characters in an attribute name from being misinterpreted in an expression.
     * </li>
     * </ul>
     * Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the following
     * attribute name:
     * <ul>
     * <li>
     * <code>Percentile</code><br><br>
     * </li>
     * </ul>
     * The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression. (For
     * the complete list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the following for
     * <code>ExpressionAttributeNames</code>:
     * <ul>
     * <li>
     * <code>{"#P":"Percentile"}</code><br><br>
     * </li>
     * </ul>
     * You could then use this substitution in an expression, as in this example:
     * <ul>
     * <li>
     * <code>#P = :val</code><br><br>
     * </li>
     * </ul>
     * <note>
     * Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are placeholders for
     * the actual value at runtime.
     * </note>
     * For more information on expression attribute names, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param expressionAttributeNames
     *        One or more substitution tokens for attribute names in an expression. The following are some use cases for
     *        <ul>
     *        <li>
     *        To access an attribute whose name conflicts with a DynamoDB reserved word.
     *        </li>
     *        <li>
     *        To create a placeholder for repeating occurrences of an attribute name in an expression.
     *        </li>
     *        <li>
     *        To prevent special characters in an attribute name from being misinterpreted in an expression.
     *        </li>
     *        </ul>
     *        Use the <b>#</b> character in an expression to dereference an attribute name. For example, consider the
     *        following attribute name:
     *        <ul>
     *        <li>
     *        <code>Percentile</code><br><br>
     *        </li>
     *        </ul>
     *        The name of this attribute conflicts with a reserved word, so it cannot be used directly in an expression.
     *        (For the complete list of reserved words, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *        Words</a> in the <i>Amazon DynamoDB Developer Guide</i>). To work around this, you could specify the
     *        following for <code>ExpressionAttributeNames</code>:
     *        <ul>
     *        <li>
     *        <code>{"#P":"Percentile"}</code><br><br>
     *        </li>
     *        </ul>
     *        You could then use this substitution in an expression, as in this example:
     *        <ul>
     *        <li>
     *        <code>#P = :val</code><br><br>
     *        </li>
     *        </ul>
     *        <note>
     *        Tokens that begin with the <b>:</b> character are <i>expression attribute values</i>, which are
     *        placeholders for the actual value at runtime.
     *        </note>
     *        For more information on expression attribute names, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *        >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteItemRequest withExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    public DeleteItemRequest addExpressionAttributeNamesEntry(String key, String value) {
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

    public DeleteItemRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    /**
     * One or more values that can be substituted in an expression.
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <code>Available | Backordered | Discontinued</code><br><br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     * You could then use these values in an expression, such as this:
     * <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     *         Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example,
     *         suppose that you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the
     *         following:
     *         <code>Available | Backordered | Discontinued</code><br><br>
     *         You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     *         <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     *         You could then use these values in an expression, such as this:
     *         <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     *         For more information on expression attribute values, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *         >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, AttributeValue> getExpressionAttributeValues() {
        return expressionAttributeValues;
    }

    /**
     * One or more values that can be substituted in an expression.
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <code>Available | Backordered | Discontinued</code><br><br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     * You could then use these values in an expression, such as this:
     * <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param expressionAttributeValues
     *        Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example,
     *        suppose that you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the
     *        following:
     *        <code>Available | Backordered | Discontinued</code><br><br>
     *        You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     *        <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     *        You could then use these values in an expression, such as this:
     *        <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     *        For more information on expression attribute values, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        this.expressionAttributeValues = expressionAttributeValues;
    }

    /**
     * One or more values that can be substituted in an expression.
     * Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example, suppose that
     * you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the following:
     * <code>Available | Backordered | Discontinued</code><br><br>
     * You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     * <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     * You could then use these values in an expression, such as this:
     * <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     * For more information on expression attribute values, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     * >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * 
     * @param expressionAttributeValues
     *        Use the <b>:</b> (colon) character in an expression to dereference an attribute value. For example,
     *        suppose that you wanted to check whether the value of the <i>ProductStatus</i> attribute was one of the
     *        following:
     *        <code>Available | Backordered | Discontinued</code><br><br>
     *        You would first need to specify <code>ExpressionAttributeValues</code> as follows:
     *        <code>{ ":avail":{"S":"Available"}, ":back":{"S":"Backordered"}, ":disc":{"S":"Discontinued"} }</code><br><br>
     *        You could then use these values in an expression, such as this:
     *        <code>ProductStatus IN (:avail, :back, :disc)</code><br><br>
     *        For more information on expression attribute values, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.SpecifyingConditions.html"
     *        >Specifying Conditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteItemRequest withExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    public DeleteItemRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
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

    public DeleteItemRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    /**
     * Set the hash and range key attributes of the item.
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
     * For a hash-only table, you only need to provide the hash attribute. For a hash-and-range table, you must provide
     * both.
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param hashKey
     *        a map entry including the name and value of the primary hash key.
     * @param rangeKey
     *        a map entry including the name and value of the primary range key, or null if it is a hash-only table.
     */
    public DeleteItemRequest withKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        setKey(hashKey, rangeKey);
        return this;
    }
}
