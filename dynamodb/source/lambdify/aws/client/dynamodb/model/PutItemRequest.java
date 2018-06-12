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
 * Represents the input of a <code>PutItem</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/PutItem" target="_top">AWS API
 *      Documentation</a>
 */
@NoArgsConstructor
@EqualsAndHashCode @ToString
public class PutItemRequest implements Serializable, Cloneable {

    /**
     * <br>
     * The name of the table to contain the item.
     * <br>
     */
    @JsonProperty("TableName") private String tableName;
    /**
     * <br>
     * A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required; you
     * can optionally provide other attribute name-value pairs for the item.
     * <br>
     * <br>
     * You must provide all of the attributes for the primary key. For example, with a simple primary key, you only need
     * to provide a value for the partition key. For a composite primary key, you must provide both values for both the
     * partition key and the sort key.
     * <br>
     * <br>
     * If you specify any attributes that are part of an index key, then the data types for those attributes must match
     * those of the schema in the table's attribute definition.
     * <br>
     * <br>
     * For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * <br>
     */
    @JsonProperty("Item") private java.util.Map<String, AttributeValue> item;

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were updated
     * with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     * <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of the
     * old item is returned.
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>PutItem</code>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * <br>
     * </note>
     */
    @JsonProperty("ReturnValues") private String returnValues;

    @JsonProperty("ReturnConsumedCapacity") private String returnConsumedCapacity;
    /**
     * <br>
     * Determines whether item collection metrics are returned. If set to <code>SIZE</code>, the response includes
     * statistics about item collections, if any, that were modified during the operation are returned in the response.
     * If set to <code>NONE</code> (the default), no statistics are returned.
     * <br>
     */
    @JsonProperty("ReturnItemCollectionMetrics") private String returnItemCollectionMetrics;
    /**
     * <br>
     * This is a legacy parameter. Use <code>ConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ConditionalOperator") private String conditionalOperator;
    /**
     * <br>
     * A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to succeed.
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
    @JsonProperty("ConditionExpression") private String conditionExpression;
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
    @JsonProperty("ExpressionAttributeNames") private java.util.Map<String, String> expressionAttributeNames;
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
    @JsonProperty("ExpressionAttributeValues") private java.util.Map<String, AttributeValue> expressionAttributeValues;

    /**
     * Constructs a new PutItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table to contain the item.
     * @param item
     *        A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required;
     *        you can optionally provide other attribute name-value pairs for the item.<br>
     *        <br>
     *        You must provide all of the attributes for the primary key. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide both
     *        values for both the partition key and the sort key.
     *        <br>
     *        <br>
     *        If you specify any attributes that are part of an index key, then the data types for those attributes must
     *        match those of the schema in the table's attribute definition.
     *        <br>
     *        <br>
     *        For more information about primary keys, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey"
     *        >Primary Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     */
    public PutItemRequest(String tableName, java.util.Map<String, AttributeValue> item) {
        setTableName(tableName);
        setItem(item);
    }

    /**
     * Constructs a new PutItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table to contain the item.
     * @param item
     *        A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required;
     *        you can optionally provide other attribute name-value pairs for the item.<br>
     *        <br>
     *        You must provide all of the attributes for the primary key. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide both
     *        values for both the partition key and the sort key.
     *        <br>
     *        <br>
     *        If you specify any attributes that are part of an index key, then the data types for those attributes must
     *        match those of the schema in the table's attribute definition.
     *        <br>
     *        <br>
     *        For more information about primary keys, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey"
     *        >Primary Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     *        <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of
     *        the old item is returned.
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *        <br>
     */
    public PutItemRequest(String tableName, java.util.Map<String, AttributeValue> item, String returnValues) {
        setTableName(tableName);
        setItem(item);
        setReturnValues(returnValues);
    }

    /**
     * Constructs a new PutItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table to contain the item.
     * @param item
     *        A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required;
     *        you can optionally provide other attribute name-value pairs for the item.<br>
     *        <br>
     *        You must provide all of the attributes for the primary key. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide both
     *        values for both the partition key and the sort key.
     *        <br>
     *        <br>
     *        If you specify any attributes that are part of an index key, then the data types for those attributes must
     *        match those of the schema in the table's attribute definition.
     *        <br>
     *        <br>
     *        For more information about primary keys, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey"
     *        >Primary Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     *        <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of
     *        the old item is returned.
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *        <br>
     */
    public PutItemRequest(String tableName, java.util.Map<String, AttributeValue> item, ReturnValue returnValues) {
        setTableName(tableName);
        setItem(item);
        setReturnValues(returnValues.toString());
    }

    /**
     * <br>
     * The name of the table to contain the item.
     * <br>
     *
     * @param tableName
     *        The name of the table to contain the item.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * <br>
     * The name of the table to contain the item.
     * <br>
     *
     * @return The name of the table to contain the item.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * <br>
     * The name of the table to contain the item.
     * <br>
     *
     * @param tableName
     *        The name of the table to contain the item.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PutItemRequest withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * <br>
     * A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required; you
     * can optionally provide other attribute name-value pairs for the item.
     * <br>
     * <br>
     * You must provide all of the attributes for the primary key. For example, with a simple primary key, you only need
     * to provide a value for the partition key. For a composite primary key, you must provide both values for both the
     * partition key and the sort key.
     * <br>
     * <br>
     * If you specify any attributes that are part of an index key, then the data types for those attributes must match
     * those of the schema in the table's attribute definition.
     * <br>
     * <br>
     * For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * <br>
     *
     * @return A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are
     *         required; you can optionally provide other attribute name-value pairs for the item.<br>
     *         <br>
     *         You must provide all of the attributes for the primary key. For example, with a simple primary key, you
     *         only need to provide a value for the partition key. For a composite primary key, you must provide both
     *         values for both the partition key and the sort key.
     *         <br>
     *         <br>
     *         If you specify any attributes that are part of an index key, then the data types for those attributes
     *         must match those of the schema in the table's attribute definition.
     *         <br>
     *         <br>
     *         For more information about primary keys, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey"
     *         >Primary Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <br>
     *         <br>
     *         Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     */

    public java.util.Map<String, AttributeValue> getItem() {
        return item;
    }

    /**
     * <br>
     * A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required; you
     * can optionally provide other attribute name-value pairs for the item.
     * <br>
     * <br>
     * You must provide all of the attributes for the primary key. For example, with a simple primary key, you only need
     * to provide a value for the partition key. For a composite primary key, you must provide both values for both the
     * partition key and the sort key.
     * <br>
     * <br>
     * If you specify any attributes that are part of an index key, then the data types for those attributes must match
     * those of the schema in the table's attribute definition.
     * <br>
     * <br>
     * For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * <br>
     *
     * @param item
     *        A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required;
     *        you can optionally provide other attribute name-value pairs for the item.<br>
     *        <br>
     *        You must provide all of the attributes for the primary key. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide both
     *        values for both the partition key and the sort key.
     *        <br>
     *        <br>
     *        If you specify any attributes that are part of an index key, then the data types for those attributes must
     *        match those of the schema in the table's attribute definition.
     *        <br>
     *        <br>
     *        For more information about primary keys, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey"
     *        >Primary Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     */

    public void setItem(java.util.Map<String, AttributeValue> item) {
        this.item = item;
    }

    /**
     * <br>
     * A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required; you
     * can optionally provide other attribute name-value pairs for the item.
     * <br>
     * <br>
     * You must provide all of the attributes for the primary key. For example, with a simple primary key, you only need
     * to provide a value for the partition key. For a composite primary key, you must provide both values for both the
     * partition key and the sort key.
     * <br>
     * <br>
     * If you specify any attributes that are part of an index key, then the data types for those attributes must match
     * those of the schema in the table's attribute definition.
     * <br>
     * <br>
     * For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * <br>
     *
     * @param item
     *        A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required;
     *        you can optionally provide other attribute name-value pairs for the item.<br>
     *        <br>
     *        You must provide all of the attributes for the primary key. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide both
     *        values for both the partition key and the sort key.
     *        <br>
     *        <br>
     *        If you specify any attributes that are part of an index key, then the data types for those attributes must
     *        match those of the schema in the table's attribute definition.
     *        <br>
     *        <br>
     *        For more information about primary keys, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey"
     *        >Primary Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        Each element in the <code>Item</code> map is an <code>AttributeValue</code> object.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PutItemRequest withItem(java.util.Map<String, AttributeValue> item) {
        setItem(item);
        return this;
    }

    public PutItemRequest addItemEntry(String key, AttributeValue value) {
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

    public PutItemRequest clearItemEntries() {
        this.item = null;
        return this;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were updated
     * with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     * <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of the
     * old item is returned.
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>PutItem</code>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * <br>
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of
     *        the old item is returned.
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *        <br>
     * @see ReturnValue
     */

    public void setReturnValues(String returnValues) {
        this.returnValues = returnValues;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were updated
     * with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     * <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of the
     * old item is returned.
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>PutItem</code>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * <br>
     * </note>
     * 
     * @return Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *         updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *         then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content
     *         of the old item is returned.
     *         <br>
     *         </li>
     *         </ul>
     *         <note>
     *         <br>
     *         The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *         <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *         <br>
     * @see ReturnValue
     */

    public String getReturnValues() {
        return this.returnValues;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were updated
     * with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     * <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of the
     * old item is returned.
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>PutItem</code>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * <br>
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of
     *        the old item is returned.
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *        <br>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnValue
     */

    public PutItemRequest withReturnValues(String returnValues) {
        setReturnValues(returnValues);
        return this;
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were updated
     * with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     * <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of the
     * old item is returned.
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>PutItem</code>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * <br>
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of
     *        the old item is returned.
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *        <br>
     * @see ReturnValue
     */

    public void setReturnValues(ReturnValue returnValues) {
        this.returnValues = returnValues.toString();
    }

    /**
     * <br>
     * Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were updated
     * with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:
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
     * <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of the
     * old item is returned.
     * <br>
     * </li>
     * </ul>
     * <note>
     * <br>
     * The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however, <code>PutItem</code>
     * does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     * <br>
     * </note>
     * 
     * @param returnValues
     *        Use <code>ReturnValues</code> if you want to get the item attributes as they appeared before they were
     *        updated with the <code>PutItem</code> request. For <code>PutItem</code>, the valid values are:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>NONE</code> - If <code>ReturnValues</code> is not specified, or if its value is <code>NONE</code>,
     *        then nothing is returned. (This setting is the default for <code>ReturnValues</code>.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_OLD</code> - If <code>PutItem</code> overwrote an attribute name-value pair, then the content of
     *        the old item is returned.
     *        <br>
     *        </li>
     *        </ul>
     *        <note>
     *        <br>
     *        The <code>ReturnValues</code> parameter is used by several DynamoDB operations; however,
     *        <code>PutItem</code> does not recognize any values other than <code>NONE</code> or <code>ALL_OLD</code>.
     *        <br>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ReturnValue
     */

    public PutItemRequest withReturnValues(ReturnValue returnValues) {
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

    public PutItemRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
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

    public PutItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
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

    public PutItemRequest withReturnItemCollectionMetrics(String returnItemCollectionMetrics) {
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

    public PutItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics) {
        setReturnItemCollectionMetrics(returnItemCollectionMetrics);
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

    public PutItemRequest withConditionalOperator(String conditionalOperator) {
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

    public PutItemRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * <br>
     * A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to succeed.
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
     *        A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to
     *        succeed.<br>
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
     * A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to succeed.
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
     * @return A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to
     *         succeed.<br>
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
     * A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to succeed.
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
     *        A condition that must be satisfied in order for a conditional <code>PutItem</code> operation to
     *        succeed.<br>
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

    public PutItemRequest withConditionExpression(String conditionExpression) {
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

    public PutItemRequest withExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    public PutItemRequest addExpressionAttributeNamesEntry(String key, String value) {
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

    public PutItemRequest clearExpressionAttributeNamesEntries() {
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

    public PutItemRequest withExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    public PutItemRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
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

    public PutItemRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }
}
