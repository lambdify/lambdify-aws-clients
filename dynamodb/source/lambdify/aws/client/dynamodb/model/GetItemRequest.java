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
 * Represents the input of a <code>GetItem</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/GetItem" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class GetItemRequest implements Serializable {

    /**
     * <br>
     * The name of the table containing the requested item.
     * <br>
     */
    @JsonProperty("TableName")
    private String tableName;
    /**
     * <br>
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * retrieve.
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
     * This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     * >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("AttributesToGet")
    private java.util.List<String> attributesToGet;
    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     */
    @JsonProperty("ConsistentRead")
    private Boolean consistentRead;

    @JsonProperty("ReturnConsumedCapacity")
    private String returnConsumedCapacity;
    /**
     * <br>
     * A string that identifies one or more attributes to retrieve from the table. These attributes can include scalars,
     * sets, or elements of a JSON document. The attributes in the expression must be separated by commas.
     * <br>
     * <br>
     * If no attribute names are specified, then all attributes will be returned. If any of the requested attributes are
     * not found, they will not appear in the result.
     * <br>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ProjectionExpression")
    private String projectionExpression;
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
     * Default constructor for GetItemRequest object. Callers should use the setter or fluent setter (with...) methods
     * to initialize the object after creating it.
     */
    public GetItemRequest() {
    }

    /**
     * Constructs a new GetItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the requested item.
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        to retrieve.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     */
    public GetItemRequest(String tableName, java.util.Map<String, AttributeValue> key) {
        setTableName(tableName);
        setKey(key);
    }

    /**
     * Constructs a new GetItemRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the requested item.
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        to retrieve.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @param consistentRead
     *        Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *        consistent reads; otherwise, the operation uses eventually consistent reads.
     */
    public GetItemRequest(String tableName, java.util.Map<String, AttributeValue> key, Boolean consistentRead) {
        setTableName(tableName);
        setKey(key);
        setConsistentRead(consistentRead);
    }

    /**
     * <br>
     * The name of the table containing the requested item.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the requested item.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * <br>
     * The name of the table containing the requested item.
     * <br>
     *
     * @return The name of the table containing the requested item.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * <br>
     * The name of the table containing the requested item.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the requested item.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemRequest withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * <br>
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * retrieve.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     *
     * @return A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *         to retrieve.<br>
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
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * retrieve.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     *
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        to retrieve.<br>
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
     * A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item to
     * retrieve.
     * <br>
     * <br>
     * For the primary key, you must provide all of the attributes. For example, with a simple primary key, you only
     * need to provide a value for the partition key. For a composite primary key, you must provide values for both the
     * partition key and the sort key.
     * <br>
     *
     * @param key
     *        A map of attribute names to <code>AttributeValue</code> objects, representing the primary key of the item
     *        to retrieve.<br>
     *        <br>
     *        For the primary key, you must provide all of the attributes. For example, with a simple primary key, you
     *        only need to provide a value for the partition key. For a composite primary key, you must provide values
     *        for both the partition key and the sort key.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemRequest withKey(java.util.Map<String, AttributeValue> key) {
        setKey(key);
        return this;
    }

    public GetItemRequest addKeyEntry(String key, AttributeValue value) {
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

    public GetItemRequest clearKeyEntries() {
        this.key = null;
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     * >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a
     *         href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     *         >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.List<String> getAttributesToGet() {
        return attributesToGet;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     * >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param attributesToGet
     *        This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     *        >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setAttributesToGet(java.util.Collection<String> attributesToGet) {
        if (attributesToGet == null) {
            this.attributesToGet = null;
            return;
        }

        this.attributesToGet = new java.util.ArrayList<String>(attributesToGet);
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     * >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setAttributesToGet(java.util.Collection)} or {@link #withAttributesToGet(java.util.Collection)} if you
     * want to override the existing values.
     * <br>
     *
     * @param attributesToGet
     *        This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     *        >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemRequest withAttributesToGet(String... attributesToGet) {
        if (this.attributesToGet == null) {
            setAttributesToGet(new java.util.ArrayList<String>(attributesToGet.length));
        }
        for (String ele : attributesToGet) {
            this.attributesToGet.add(ele);
        }
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     * >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param attributesToGet
     *        This is a legacy parameter. Use <code>ProjectionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.AttributesToGet.html"
     *        >AttributesToGet</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemRequest withAttributesToGet(java.util.Collection<String> attributesToGet) {
        setAttributesToGet(attributesToGet);
        return this;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     *
     * @param consistentRead
     *        Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *        consistent reads; otherwise, the operation uses eventually consistent reads.
     */

    public void setConsistentRead(Boolean consistentRead) {
        this.consistentRead = consistentRead;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     *
     * @return Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *         consistent reads; otherwise, the operation uses eventually consistent reads.
     */

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     *
     * @param consistentRead
     *        Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *        consistent reads; otherwise, the operation uses eventually consistent reads.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemRequest withConsistentRead(Boolean consistentRead) {
        setConsistentRead(consistentRead);
        return this;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     *
     * @return Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *         consistent reads; otherwise, the operation uses eventually consistent reads.
     */

    public Boolean isConsistentRead() {
        return this.consistentRead;
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

    public GetItemRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
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

    public GetItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        setReturnConsumedCapacity(returnConsumedCapacity);
        return this;
    }

    /**
     * <br>
     * A string that identifies one or more attributes to retrieve from the table. These attributes can include scalars,
     * sets, or elements of a JSON document. The attributes in the expression must be separated by commas.
     * <br>
     * <br>
     * If no attribute names are specified, then all attributes will be returned. If any of the requested attributes are
     * not found, they will not appear in the result.
     * <br>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param projectionExpression
     *        A string that identifies one or more attributes to retrieve from the table. These attributes can include
     *        scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     *        commas.<br>
     *        <br>
     *        If no attribute names are specified, then all attributes will be returned. If any of the requested
     *        attributes are not found, they will not appear in the result.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *        >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setProjectionExpression(String projectionExpression) {
        this.projectionExpression = projectionExpression;
    }

    /**
     * <br>
     * A string that identifies one or more attributes to retrieve from the table. These attributes can include scalars,
     * sets, or elements of a JSON document. The attributes in the expression must be separated by commas.
     * <br>
     * <br>
     * If no attribute names are specified, then all attributes will be returned. If any of the requested attributes are
     * not found, they will not appear in the result.
     * <br>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return A string that identifies one or more attributes to retrieve from the table. These attributes can include
     *         scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     *         commas.<br>
     *         <br>
     *         If no attribute names are specified, then all attributes will be returned. If any of the requested
     *         attributes are not found, they will not appear in the result.
     *         <br>
     *         <br>
     *         For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *         >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public String getProjectionExpression() {
        return this.projectionExpression;
    }

    /**
     * <br>
     * A string that identifies one or more attributes to retrieve from the table. These attributes can include scalars,
     * sets, or elements of a JSON document. The attributes in the expression must be separated by commas.
     * <br>
     * <br>
     * If no attribute names are specified, then all attributes will be returned. If any of the requested attributes are
     * not found, they will not appear in the result.
     * <br>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     * >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param projectionExpression
     *        A string that identifies one or more attributes to retrieve from the table. These attributes can include
     *        scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     *        commas.<br>
     *        <br>
     *        If no attribute names are specified, then all attributes will be returned. If any of the requested
     *        attributes are not found, they will not appear in the result.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.AccessingItemAttributes.html"
     *        >Accessing Item Attributes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetItemRequest withProjectionExpression(String projectionExpression) {
        setProjectionExpression(projectionExpression);
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

    public GetItemRequest withExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    public GetItemRequest addExpressionAttributeNamesEntry(String key, String value) {
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

    public GetItemRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
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
    public GetItemRequest withKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        setKey(hashKey, rangeKey);
        return this;
    }
}
