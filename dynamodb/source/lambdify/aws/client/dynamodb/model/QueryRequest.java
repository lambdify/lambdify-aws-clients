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
import java.util.concurrent.locks.Condition;
import com.fasterxml.jackson.annotation.JsonProperty;
import lambdify.aws.events.dynamodb.AttributeValue;
import lombok.*;

/**
 * <br>
 * Represents the input of a <code>Query</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/Query" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class QueryRequest implements Serializable {

    /**
     * <br>
     * The name of the table containing the requested items.
     * <br>
     */
    @JsonProperty("TableName")
    private String tableName;
    /**
     * <br>
     * The name of an index to query. This index can be any local secondary index or global secondary index on the
     * table. Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName.</code>
     * <br>
     */
    @JsonProperty("IndexName")
    private String indexName;
    /**
     * <br>
     * The attributes to be returned in the result. You can retrieve all item attributes, specific item attributes, the
     * count of matching items, or in the case of an index, some or all of the attributes projected into the index.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you query
     * a local secondary index, then for each matching item in the index DynamoDB will fetch the entire item from the
     * parent table. If the index is configured to project all item attributes, then all of the data can be obtained
     * from the local secondary index, and no fetching is required.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that have
     * been projected into the index. If the index is configured to project all attributes, this return value is
     * equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>. This
     * return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value for
     * <code>Select</code>.
     * <br>
     * <br>
     * If you query or scan a local secondary index and request only attributes that are projected into that index, the
     * operation will read only the index and not the table. If any of the requested attributes are not projected into
     * the local secondary index, DynamoDB will fetch each of these attributes from the parent table. This extra
     * fetching incurs additional throughput cost and latency.
     * <br>
     * <br>
     * If you query or scan a global secondary index, you can only request attributes that are projected into the index.
     * Global secondary index queries cannot fetch attributes from the parent table.
     * <br>
     * </li>
     * </ul>
     * <br>
     * If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when accessing an
     * index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a single request,
     * unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     * <br>
     * <note>
     * <br>
     * If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can only be
     * <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     * <br>
     * </note>
     */
    @JsonProperty("Select")
    private String select;
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
     * The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB processes the
     * number of items up to the limit while processing the results, it stops the operation and returns the matching
     * values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set size exceeds 1 MB before DynamoDB reaches
     * this limit, it stops the operation and returns the matching values up to the limit, and a key in
     * <code>LastEvaluatedKey</code> to apply in a subsequent operation to continue the operation. For more information,
     * see <a href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     * Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("Limit")
    private Integer limit;
    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     * <br>
     * Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary index
     * with <code>ConsistentRead</code> set to <code>true</code>, you will receive a <code>ValidationException</code>.
     * <br>
     */
    @JsonProperty("ConsistentRead")
    private Boolean consistentRead;
    /**
     * <br>
     * This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     * >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("KeyConditions")
    private java.util.Map<String, Condition> keyConditions;
    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     * >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("QueryFilter")
    private java.util.Map<String, Condition> queryFilter;
    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ConditionalOperator")
    private String conditionalOperator;
    /**
     * <br>
     * Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in ascending
     * order; if <code>false</code>, the traversal is performed in descending order.
     * <br>
     * <br>
     * Items with the same partition key value are stored in sorted order by sort key. If the sort key data type is
     * Number, the results are stored in numeric order. For type String, the results are stored in order of ASCII
     * character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     * <br>
     * <br>
     * If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which they
     * are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     * <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the results
     * to the client.
     * <br>
     */
    @JsonProperty("ScanIndexForward")
    private Boolean scanIndexForward;
    /**
     * <br>
     * The primary key of the first item that this operation will evaluate. Use the value that was returned for
     * <code>LastEvaluatedKey</code> in the previous operation.
     * <br>
     * <br>
     * The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are allowed.
     * <br>
     */
    @JsonProperty("ExclusiveStartKey")
    private java.util.Map<String, AttributeValue> exclusiveStartKey;

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
     * A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
     * <br>
     * <br>
     * A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression based on a
     * partition key or a sort key.
     * <br>
     * <note>
     * <br>
     * A <code>FilterExpression</code> is applied after the items have already been read; the process of filtering does
     * not consume any additional read capacity units.
     * <br>
     * </note>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("FilterExpression")
    private String filterExpression;
    /**
     * <br>
     * The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code> action.
     * <br>
     * <br>
     * The condition must perform an equality test on a single partition key value. The condition can also perform one
     * of several comparison tests on a single sort key value. <code>Query</code> can use
     * <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key value, or
     * several items that have the same partition key value but different sort key values.
     * <br>
     * <br>
     * The partition key equality test is required, and must be specified in the following format:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     * <br>
     * <br>
     * If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with the
     * condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the sort key:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     * <br>
     * <br>
     * Valid comparisons for the sort key condition are as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less than or
     * equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is greater than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is greater
     * than or equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     * <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to <code>:sortkeyval1</code>, and
     * less than or equal to <code>:sortkeyval2</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if the sort
     * key value begins with a particular operand. (You cannot use this function with a sort key that is of type
     * Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as <code>:partitionval</code> and
     * <code>:sortval</code> with actual values at runtime.
     * <br>
     * <br>
     * You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the partition
     * key and sort key with placeholder tokens. This option might be necessary if an attribute name conflicts with a
     * DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code> parameter causes an error
     * because <i>Size</i> is a reserved word:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Size = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name <i>Size</i>.
     * <code>KeyConditionExpression</code> then is as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#S = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For a list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     * Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("KeyConditionExpression")
    private String keyConditionExpression;
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
     * Default constructor for QueryRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize the object after creating it.
     */
    public QueryRequest() {
    }

    /**
     * Constructs a new QueryRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the requested items.
     */
    public QueryRequest(String tableName) {
        setTableName(tableName);
    }

    /**
     * <br>
     * The name of the table containing the requested items.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the requested items.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * <br>
     * The name of the table containing the requested items.
     * <br>
     *
     * @return The name of the table containing the requested items.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * <br>
     * The name of the table containing the requested items.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the requested items.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * <br>
     * The name of an index to query. This index can be any local secondary index or global secondary index on the
     * table. Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName.</code>
     * <br>
     *
     * @param indexName
     *        The name of an index to query. This index can be any local secondary index or global secondary index on
     *        the table. Note that if you use the <code>IndexName</code> parameter, you must also provide
     *        <code>TableName.</code>
     */

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    /**
     * <br>
     * The name of an index to query. This index can be any local secondary index or global secondary index on the
     * table. Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName.</code>
     * <br>
     *
     * @return The name of an index to query. This index can be any local secondary index or global secondary index on
     *         the table. Note that if you use the <code>IndexName</code> parameter, you must also provide
     *         <code>TableName.</code>
     */

    public String getIndexName() {
        return this.indexName;
    }

    /**
     * <br>
     * The name of an index to query. This index can be any local secondary index or global secondary index on the
     * table. Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName.</code>
     * <br>
     *
     * @param indexName
     *        The name of an index to query. This index can be any local secondary index or global secondary index on
     *        the table. Note that if you use the <code>IndexName</code> parameter, you must also provide
     *        <code>TableName.</code>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withIndexName(String indexName) {
        setIndexName(indexName);
        return this;
    }

    /**
     * <br>
     * The attributes to be returned in the result. You can retrieve all item attributes, specific item attributes, the
     * count of matching items, or in the case of an index, some or all of the attributes projected into the index.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you query
     * a local secondary index, then for each matching item in the index DynamoDB will fetch the entire item from the
     * parent table. If the index is configured to project all item attributes, then all of the data can be obtained
     * from the local secondary index, and no fetching is required.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that have
     * been projected into the index. If the index is configured to project all attributes, this return value is
     * equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>. This
     * return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value for
     * <code>Select</code>.
     * <br>
     * <br>
     * If you query or scan a local secondary index and request only attributes that are projected into that index, the
     * operation will read only the index and not the table. If any of the requested attributes are not projected into
     * the local secondary index, DynamoDB will fetch each of these attributes from the parent table. This extra
     * fetching incurs additional throughput cost and latency.
     * <br>
     * <br>
     * If you query or scan a global secondary index, you can only request attributes that are projected into the index.
     * Global secondary index queries cannot fetch attributes from the parent table.
     * <br>
     * </li>
     * </ul>
     * <br>
     * If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when accessing an
     * index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a single request,
     * unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     * <br>
     * <note>
     * <br>
     * If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can only be
     * <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     * <br>
     * </note>
     * 
     * @param select
     *        The attributes to be returned in the result. You can retrieve all item attributes, specific item
     *        attributes, the count of matching items, or in the case of an index, some or all of the attributes
     *        projected into the index.<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you
     *        query a local secondary index, then for each matching item in the index DynamoDB will fetch the entire
     *        item from the parent table. If the index is configured to project all item attributes, then all of the
     *        data can be obtained from the local secondary index, and no fetching is required.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that
     *        have been projected into the index. If the index is configured to project all attributes, this return
     *        value is equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>.
     *        This return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value
     *        for <code>Select</code>.
     *        <br>
     *        <br>
     *        If you query or scan a local secondary index and request only attributes that are projected into that
     *        index, the operation will read only the index and not the table. If any of the requested attributes are
     *        not projected into the local secondary index, DynamoDB will fetch each of these attributes from the parent
     *        table. This extra fetching incurs additional throughput cost and latency.
     *        <br>
     *        <br>
     *        If you query or scan a global secondary index, you can only request attributes that are projected into the
     *        index. Global secondary index queries cannot fetch attributes from the parent table.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     *        <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when
     *        accessing an index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a
     *        single request, unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage
     *        is equivalent to specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     *        <br>
     *        <note>
     *        <br>
     *        If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can
     *        only be <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     *        <br>
     * @see Select
     */

    public void setSelect(String select) {
        this.select = select;
    }

    /**
     * <br>
     * The attributes to be returned in the result. You can retrieve all item attributes, specific item attributes, the
     * count of matching items, or in the case of an index, some or all of the attributes projected into the index.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you query
     * a local secondary index, then for each matching item in the index DynamoDB will fetch the entire item from the
     * parent table. If the index is configured to project all item attributes, then all of the data can be obtained
     * from the local secondary index, and no fetching is required.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that have
     * been projected into the index. If the index is configured to project all attributes, this return value is
     * equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>. This
     * return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value for
     * <code>Select</code>.
     * <br>
     * <br>
     * If you query or scan a local secondary index and request only attributes that are projected into that index, the
     * operation will read only the index and not the table. If any of the requested attributes are not projected into
     * the local secondary index, DynamoDB will fetch each of these attributes from the parent table. This extra
     * fetching incurs additional throughput cost and latency.
     * <br>
     * <br>
     * If you query or scan a global secondary index, you can only request attributes that are projected into the index.
     * Global secondary index queries cannot fetch attributes from the parent table.
     * <br>
     * </li>
     * </ul>
     * <br>
     * If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when accessing an
     * index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a single request,
     * unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     * <br>
     * <note>
     * <br>
     * If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can only be
     * <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     * <br>
     * </note>
     * 
     * @return The attributes to be returned in the result. You can retrieve all item attributes, specific item
     *         attributes, the count of matching items, or in the case of an index, some or all of the attributes
     *         projected into the index.<br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If
     *         you query a local secondary index, then for each matching item in the index DynamoDB will fetch the
     *         entire item from the parent table. If the index is configured to project all item attributes, then all of
     *         the data can be obtained from the local secondary index, and no fetching is required.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes
     *         that have been projected into the index. If the index is configured to project all attributes, this
     *         return value is equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>.
     *         This return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value
     *         for <code>Select</code>.
     *         <br>
     *         <br>
     *         If you query or scan a local secondary index and request only attributes that are projected into that
     *         index, the operation will read only the index and not the table. If any of the requested attributes are
     *         not projected into the local secondary index, DynamoDB will fetch each of these attributes from the
     *         parent table. This extra fetching incurs additional throughput cost and latency.
     *         <br>
     *         <br>
     *         If you query or scan a global secondary index, you can only request attributes that are projected into
     *         the index. Global secondary index queries cannot fetch attributes from the parent table.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     *         <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when
     *         accessing an index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in
     *         a single request, unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This
     *         usage is equivalent to specifying <code>AttributesToGet</code> without any value for <code>Select</code>
     *         .)
     *         <br>
     *         <note>
     *         <br>
     *         If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can
     *         only be <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     *         <br>
     * @see Select
     */

    public String getSelect() {
        return this.select;
    }

    /**
     * <br>
     * The attributes to be returned in the result. You can retrieve all item attributes, specific item attributes, the
     * count of matching items, or in the case of an index, some or all of the attributes projected into the index.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you query
     * a local secondary index, then for each matching item in the index DynamoDB will fetch the entire item from the
     * parent table. If the index is configured to project all item attributes, then all of the data can be obtained
     * from the local secondary index, and no fetching is required.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that have
     * been projected into the index. If the index is configured to project all attributes, this return value is
     * equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>. This
     * return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value for
     * <code>Select</code>.
     * <br>
     * <br>
     * If you query or scan a local secondary index and request only attributes that are projected into that index, the
     * operation will read only the index and not the table. If any of the requested attributes are not projected into
     * the local secondary index, DynamoDB will fetch each of these attributes from the parent table. This extra
     * fetching incurs additional throughput cost and latency.
     * <br>
     * <br>
     * If you query or scan a global secondary index, you can only request attributes that are projected into the index.
     * Global secondary index queries cannot fetch attributes from the parent table.
     * <br>
     * </li>
     * </ul>
     * <br>
     * If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when accessing an
     * index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a single request,
     * unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     * <br>
     * <note>
     * <br>
     * If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can only be
     * <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     * <br>
     * </note>
     * 
     * @param select
     *        The attributes to be returned in the result. You can retrieve all item attributes, specific item
     *        attributes, the count of matching items, or in the case of an index, some or all of the attributes
     *        projected into the index.<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you
     *        query a local secondary index, then for each matching item in the index DynamoDB will fetch the entire
     *        item from the parent table. If the index is configured to project all item attributes, then all of the
     *        data can be obtained from the local secondary index, and no fetching is required.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that
     *        have been projected into the index. If the index is configured to project all attributes, this return
     *        value is equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>.
     *        This return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value
     *        for <code>Select</code>.
     *        <br>
     *        <br>
     *        If you query or scan a local secondary index and request only attributes that are projected into that
     *        index, the operation will read only the index and not the table. If any of the requested attributes are
     *        not projected into the local secondary index, DynamoDB will fetch each of these attributes from the parent
     *        table. This extra fetching incurs additional throughput cost and latency.
     *        <br>
     *        <br>
     *        If you query or scan a global secondary index, you can only request attributes that are projected into the
     *        index. Global secondary index queries cannot fetch attributes from the parent table.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     *        <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when
     *        accessing an index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a
     *        single request, unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage
     *        is equivalent to specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     *        <br>
     *        <note>
     *        <br>
     *        If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can
     *        only be <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     *        <br>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see Select
     */

    public QueryRequest withSelect(String select) {
        setSelect(select);
        return this;
    }

    /**
     * <br>
     * The attributes to be returned in the result. You can retrieve all item attributes, specific item attributes, the
     * count of matching items, or in the case of an index, some or all of the attributes projected into the index.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you query
     * a local secondary index, then for each matching item in the index DynamoDB will fetch the entire item from the
     * parent table. If the index is configured to project all item attributes, then all of the data can be obtained
     * from the local secondary index, and no fetching is required.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that have
     * been projected into the index. If the index is configured to project all attributes, this return value is
     * equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>. This
     * return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value for
     * <code>Select</code>.
     * <br>
     * <br>
     * If you query or scan a local secondary index and request only attributes that are projected into that index, the
     * operation will read only the index and not the table. If any of the requested attributes are not projected into
     * the local secondary index, DynamoDB will fetch each of these attributes from the parent table. This extra
     * fetching incurs additional throughput cost and latency.
     * <br>
     * <br>
     * If you query or scan a global secondary index, you can only request attributes that are projected into the index.
     * Global secondary index queries cannot fetch attributes from the parent table.
     * <br>
     * </li>
     * </ul>
     * <br>
     * If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when accessing an
     * index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a single request,
     * unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     * <br>
     * <note>
     * <br>
     * If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can only be
     * <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     * <br>
     * </note>
     * 
     * @param select
     *        The attributes to be returned in the result. You can retrieve all item attributes, specific item
     *        attributes, the count of matching items, or in the case of an index, some or all of the attributes
     *        projected into the index.<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you
     *        query a local secondary index, then for each matching item in the index DynamoDB will fetch the entire
     *        item from the parent table. If the index is configured to project all item attributes, then all of the
     *        data can be obtained from the local secondary index, and no fetching is required.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that
     *        have been projected into the index. If the index is configured to project all attributes, this return
     *        value is equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>.
     *        This return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value
     *        for <code>Select</code>.
     *        <br>
     *        <br>
     *        If you query or scan a local secondary index and request only attributes that are projected into that
     *        index, the operation will read only the index and not the table. If any of the requested attributes are
     *        not projected into the local secondary index, DynamoDB will fetch each of these attributes from the parent
     *        table. This extra fetching incurs additional throughput cost and latency.
     *        <br>
     *        <br>
     *        If you query or scan a global secondary index, you can only request attributes that are projected into the
     *        index. Global secondary index queries cannot fetch attributes from the parent table.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     *        <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when
     *        accessing an index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a
     *        single request, unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage
     *        is equivalent to specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     *        <br>
     *        <note>
     *        <br>
     *        If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can
     *        only be <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     *        <br>
     * @see Select
     */

    public void setSelect(Select select) {
        this.select = select.toString();
    }

    /**
     * <br>
     * The attributes to be returned in the result. You can retrieve all item attributes, specific item attributes, the
     * count of matching items, or in the case of an index, some or all of the attributes projected into the index.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you query
     * a local secondary index, then for each matching item in the index DynamoDB will fetch the entire item from the
     * parent table. If the index is configured to project all item attributes, then all of the data can be obtained
     * from the local secondary index, and no fetching is required.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that have
     * been projected into the index. If the index is configured to project all attributes, this return value is
     * equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>. This
     * return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value for
     * <code>Select</code>.
     * <br>
     * <br>
     * If you query or scan a local secondary index and request only attributes that are projected into that index, the
     * operation will read only the index and not the table. If any of the requested attributes are not projected into
     * the local secondary index, DynamoDB will fetch each of these attributes from the parent table. This extra
     * fetching incurs additional throughput cost and latency.
     * <br>
     * <br>
     * If you query or scan a global secondary index, you can only request attributes that are projected into the index.
     * Global secondary index queries cannot fetch attributes from the parent table.
     * <br>
     * </li>
     * </ul>
     * <br>
     * If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     * <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when accessing an
     * index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a single request,
     * unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage is equivalent to
     * specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     * <br>
     * <note>
     * <br>
     * If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can only be
     * <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     * <br>
     * </note>
     * 
     * @param select
     *        The attributes to be returned in the result. You can retrieve all item attributes, specific item
     *        attributes, the count of matching items, or in the case of an index, some or all of the attributes
     *        projected into the index.<br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>ALL_ATTRIBUTES</code> - Returns all of the item attributes from the specified table or index. If you
     *        query a local secondary index, then for each matching item in the index DynamoDB will fetch the entire
     *        item from the parent table. If the index is configured to project all item attributes, then all of the
     *        data can be obtained from the local secondary index, and no fetching is required.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ALL_PROJECTED_ATTRIBUTES</code> - Allowed only when querying an index. Retrieves all attributes that
     *        have been projected into the index. If the index is configured to project all attributes, this return
     *        value is equivalent to specifying <code>ALL_ATTRIBUTES</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>COUNT</code> - Returns the number of matching items, rather than the matching items themselves.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>SPECIFIC_ATTRIBUTES</code> - Returns only the attributes listed in <code>AttributesToGet</code>.
     *        This return value is equivalent to specifying <code>AttributesToGet</code> without specifying any value
     *        for <code>Select</code>.
     *        <br>
     *        <br>
     *        If you query or scan a local secondary index and request only attributes that are projected into that
     *        index, the operation will read only the index and not the table. If any of the requested attributes are
     *        not projected into the local secondary index, DynamoDB will fetch each of these attributes from the parent
     *        table. This extra fetching incurs additional throughput cost and latency.
     *        <br>
     *        <br>
     *        If you query or scan a global secondary index, you can only request attributes that are projected into the
     *        index. Global secondary index queries cannot fetch attributes from the parent table.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        If neither <code>Select</code> nor <code>AttributesToGet</code> are specified, DynamoDB defaults to
     *        <code>ALL_ATTRIBUTES</code> when accessing a table, and <code>ALL_PROJECTED_ATTRIBUTES</code> when
     *        accessing an index. You cannot use both <code>Select</code> and <code>AttributesToGet</code> together in a
     *        single request, unless the value for <code>Select</code> is <code>SPECIFIC_ATTRIBUTES</code>. (This usage
     *        is equivalent to specifying <code>AttributesToGet</code> without any value for <code>Select</code>.)
     *        <br>
     *        <note>
     *        <br>
     *        If you use the <code>ProjectionExpression</code> parameter, then the value for <code>Select</code> can
     *        only be <code>SPECIFIC_ATTRIBUTES</code>. Any other value for <code>Select</code> will return an error.
     *        <br>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see Select
     */

    public QueryRequest withSelect(Select select) {
        setSelect(select);
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

    public QueryRequest withAttributesToGet(String... attributesToGet) {
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

    public QueryRequest withAttributesToGet(java.util.Collection<String> attributesToGet) {
        setAttributesToGet(attributesToGet);
        return this;
    }

    /**
     * <br>
     * The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB processes the
     * number of items up to the limit while processing the results, it stops the operation and returns the matching
     * values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set size exceeds 1 MB before DynamoDB reaches
     * this limit, it stops the operation and returns the matching values up to the limit, and a key in
     * <code>LastEvaluatedKey</code> to apply in a subsequent operation to continue the operation. For more information,
     * see <a href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     * Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param limit
     *        The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB
     *        processes the number of items up to the limit while processing the results, it stops the operation and
     *        returns the matching values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a
     *        subsequent operation, so that you can pick up where you left off. Also, if the processed data set size
     *        exceeds 1 MB before DynamoDB reaches this limit, it stops the operation and returns the matching values up
     *        to the limit, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation to continue
     *        the operation. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     *        Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * <br>
     * The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB processes the
     * number of items up to the limit while processing the results, it stops the operation and returns the matching
     * values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set size exceeds 1 MB before DynamoDB reaches
     * this limit, it stops the operation and returns the matching values up to the limit, and a key in
     * <code>LastEvaluatedKey</code> to apply in a subsequent operation to continue the operation. For more information,
     * see <a href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     * Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB
     *         processes the number of items up to the limit while processing the results, it stops the operation and
     *         returns the matching values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a
     *         subsequent operation, so that you can pick up where you left off. Also, if the processed data set size
     *         exceeds 1 MB before DynamoDB reaches this limit, it stops the operation and returns the matching values
     *         up to the limit, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation to
     *         continue the operation. For more information, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     *         Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public Integer getLimit() {
        return this.limit;
    }

    /**
     * <br>
     * The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB processes the
     * number of items up to the limit while processing the results, it stops the operation and returns the matching
     * values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation, so that
     * you can pick up where you left off. Also, if the processed data set size exceeds 1 MB before DynamoDB reaches
     * this limit, it stops the operation and returns the matching values up to the limit, and a key in
     * <code>LastEvaluatedKey</code> to apply in a subsequent operation to continue the operation. For more information,
     * see <a href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     * Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param limit
     *        The maximum number of items to evaluate (not necessarily the number of matching items). If DynamoDB
     *        processes the number of items up to the limit while processing the results, it stops the operation and
     *        returns the matching values up to that point, and a key in <code>LastEvaluatedKey</code> to apply in a
     *        subsequent operation, so that you can pick up where you left off. Also, if the processed data set size
     *        exceeds 1 MB before DynamoDB reaches this limit, it stops the operation and returns the matching values up
     *        to the limit, and a key in <code>LastEvaluatedKey</code> to apply in a subsequent operation to continue
     *        the operation. For more information, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html">Query and
     *        Scan</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withLimit(Integer limit) {
        setLimit(limit);
        return this;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     * <br>
     * Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary index
     * with <code>ConsistentRead</code> set to <code>true</code>, you will receive a <code>ValidationException</code>.
     * <br>
     *
     * @param consistentRead
     *        Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *        consistent reads; otherwise, the operation uses eventually consistent reads.<br>
     *        <br>
     *        Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary
     *        index with <code>ConsistentRead</code> set to <code>true</code>, you will receive a
     *        <code>ValidationException</code>.
     */

    public void setConsistentRead(Boolean consistentRead) {
        this.consistentRead = consistentRead;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     * <br>
     * Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary index
     * with <code>ConsistentRead</code> set to <code>true</code>, you will receive a <code>ValidationException</code>.
     * <br>
     *
     * @return Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *         consistent reads; otherwise, the operation uses eventually consistent reads.<br>
     *         <br>
     *         Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary
     *         index with <code>ConsistentRead</code> set to <code>true</code>, you will receive a
     *         <code>ValidationException</code>.
     */

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     * <br>
     * Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary index
     * with <code>ConsistentRead</code> set to <code>true</code>, you will receive a <code>ValidationException</code>.
     * <br>
     *
     * @param consistentRead
     *        Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *        consistent reads; otherwise, the operation uses eventually consistent reads.<br>
     *        <br>
     *        Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary
     *        index with <code>ConsistentRead</code> set to <code>true</code>, you will receive a
     *        <code>ValidationException</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withConsistentRead(Boolean consistentRead) {
        setConsistentRead(consistentRead);
        return this;
    }

    /**
     * <br>
     * Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly consistent
     * reads; otherwise, the operation uses eventually consistent reads.
     * <br>
     * <br>
     * Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary index
     * with <code>ConsistentRead</code> set to <code>true</code>, you will receive a <code>ValidationException</code>.
     * <br>
     *
     * @return Determines the read consistency model: If set to <code>true</code>, then the operation uses strongly
     *         consistent reads; otherwise, the operation uses eventually consistent reads.<br>
     *         <br>
     *         Strongly consistent reads are not supported on global secondary indexes. If you query a global secondary
     *         index with <code>ConsistentRead</code> set to <code>true</code>, you will receive a
     *         <code>ValidationException</code>.
     */

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     * >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a
     *         href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     *         >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, Condition> getKeyConditions() {
        return keyConditions;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     * >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param keyConditions
     *        This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     *        >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setKeyConditions(java.util.Map<String, Condition> keyConditions) {
        this.keyConditions = keyConditions;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     * >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param keyConditions
     *        This is a legacy parameter. Use <code>KeyConditionExpression</code> instead. For more information, see <a
     *        href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.KeyConditions.html"
     *        >KeyConditions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withKeyConditions(java.util.Map<String, Condition> keyConditions) {
        setKeyConditions(keyConditions);
        return this;
    }

    public QueryRequest addKeyConditionsEntry(String key, Condition value) {
        if (null == this.keyConditions) {
            this.keyConditions = new java.util.HashMap<String, Condition>();
        }
        if (this.keyConditions.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.keyConditions.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into KeyConditions.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest clearKeyConditionsEntries() {
        this.keyConditions = null;
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     * >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     *         >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, Condition> getQueryFilter() {
        return queryFilter;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     * >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param queryFilter
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     *        >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setQueryFilter(java.util.Map<String, Condition> queryFilter) {
        this.queryFilter = queryFilter;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     * >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param queryFilter
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.QueryFilter.html"
     *        >QueryFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withQueryFilter(java.util.Map<String, Condition> queryFilter) {
        setQueryFilter(queryFilter);
        return this;
    }

    public QueryRequest addQueryFilterEntry(String key, Condition value) {
        if (null == this.queryFilter) {
            this.queryFilter = new java.util.HashMap<String, Condition>();
        }
        if (this.queryFilter.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.queryFilter.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into QueryFilter.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest clearQueryFilterEntries() {
        this.queryFilter = null;
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @see ConditionalOperator
     */

    public void setConditionalOperator(String conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *         >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @see ConditionalOperator
     */

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ConditionalOperator
     */

    public QueryRequest withConditionalOperator(String conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @see ConditionalOperator
     */

    public void setConditionalOperator(ConditionalOperator conditionalOperator) {
        this.conditionalOperator = conditionalOperator.toString();
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     * >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param conditionalOperator
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ConditionalOperator.html"
     *        >ConditionalOperator</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ConditionalOperator
     */

    public QueryRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * <br>
     * Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in ascending
     * order; if <code>false</code>, the traversal is performed in descending order.
     * <br>
     * <br>
     * Items with the same partition key value are stored in sorted order by sort key. If the sort key data type is
     * Number, the results are stored in numeric order. For type String, the results are stored in order of ASCII
     * character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     * <br>
     * <br>
     * If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which they
     * are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     * <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the results
     * to the client.
     * <br>
     *
     * @param scanIndexForward
     *        Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in
     *        ascending order; if <code>false</code>, the traversal is performed in descending order. <br>
     *        <br>
     *        Items with the same partition key value are stored in sorted order by sort key. If the sort key data type
     *        is Number, the results are stored in numeric order. For type String, the results are stored in order of
     *        ASCII character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     *        <br>
     *        <br>
     *        If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which
     *        they are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     *        <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the
     *        results to the client.
     */

    public void setScanIndexForward(Boolean scanIndexForward) {
        this.scanIndexForward = scanIndexForward;
    }

    /**
     * <br>
     * Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in ascending
     * order; if <code>false</code>, the traversal is performed in descending order.
     * <br>
     * <br>
     * Items with the same partition key value are stored in sorted order by sort key. If the sort key data type is
     * Number, the results are stored in numeric order. For type String, the results are stored in order of ASCII
     * character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     * <br>
     * <br>
     * If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which they
     * are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     * <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the results
     * to the client.
     * <br>
     *
     * @return Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in
     *         ascending order; if <code>false</code>, the traversal is performed in descending order. <br>
     *         <br>
     *         Items with the same partition key value are stored in sorted order by sort key. If the sort key data type
     *         is Number, the results are stored in numeric order. For type String, the results are stored in order of
     *         ASCII character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     *         <br>
     *         <br>
     *         If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which
     *         they are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     *         <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the
     *         results to the client.
     */

    public Boolean getScanIndexForward() {
        return this.scanIndexForward;
    }

    /**
     * <br>
     * Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in ascending
     * order; if <code>false</code>, the traversal is performed in descending order.
     * <br>
     * <br>
     * Items with the same partition key value are stored in sorted order by sort key. If the sort key data type is
     * Number, the results are stored in numeric order. For type String, the results are stored in order of ASCII
     * character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     * <br>
     * <br>
     * If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which they
     * are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     * <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the results
     * to the client.
     * <br>
     *
     * @param scanIndexForward
     *        Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in
     *        ascending order; if <code>false</code>, the traversal is performed in descending order. <br>
     *        <br>
     *        Items with the same partition key value are stored in sorted order by sort key. If the sort key data type
     *        is Number, the results are stored in numeric order. For type String, the results are stored in order of
     *        ASCII character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     *        <br>
     *        <br>
     *        If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which
     *        they are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     *        <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the
     *        results to the client.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withScanIndexForward(Boolean scanIndexForward) {
        setScanIndexForward(scanIndexForward);
        return this;
    }

    /**
     * <br>
     * Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in ascending
     * order; if <code>false</code>, the traversal is performed in descending order.
     * <br>
     * <br>
     * Items with the same partition key value are stored in sorted order by sort key. If the sort key data type is
     * Number, the results are stored in numeric order. For type String, the results are stored in order of ASCII
     * character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     * <br>
     * <br>
     * If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which they
     * are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     * <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the results
     * to the client.
     * <br>
     *
     * @return Specifies the order for index traversal: If <code>true</code> (default), the traversal is performed in
     *         ascending order; if <code>false</code>, the traversal is performed in descending order. <br>
     *         <br>
     *         Items with the same partition key value are stored in sorted order by sort key. If the sort key data type
     *         is Number, the results are stored in numeric order. For type String, the results are stored in order of
     *         ASCII character code values. For type Binary, DynamoDB treats each byte of the binary data as unsigned.
     *         <br>
     *         <br>
     *         If <code>ScanIndexForward</code> is <code>true</code>, DynamoDB returns the results in the order in which
     *         they are stored (by sort key value). This is the default behavior. If <code>ScanIndexForward</code> is
     *         <code>false</code>, DynamoDB reads the results in reverse order by sort key value, and then returns the
     *         results to the client.
     */

    public Boolean isScanIndexForward() {
        return this.scanIndexForward;
    }

    /**
     * <br>
     * The primary key of the first item that this operation will evaluate. Use the value that was returned for
     * <code>LastEvaluatedKey</code> in the previous operation.
     * <br>
     * <br>
     * The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are allowed.
     * <br>
     *
     * @return The primary key of the first item that this operation will evaluate. Use the value that was returned for
     *         <code>LastEvaluatedKey</code> in the previous operation.<br>
     *         <br>
     *         The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are
     *         allowed.
     */

    public java.util.Map<String, AttributeValue> getExclusiveStartKey() {
        return exclusiveStartKey;
    }

    /**
     * <br>
     * The primary key of the first item that this operation will evaluate. Use the value that was returned for
     * <code>LastEvaluatedKey</code> in the previous operation.
     * <br>
     * <br>
     * The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are allowed.
     * <br>
     *
     * @param exclusiveStartKey
     *        The primary key of the first item that this operation will evaluate. Use the value that was returned for
     *        <code>LastEvaluatedKey</code> in the previous operation.<br>
     *        <br>
     *        The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are
     *        allowed.
     */

    public void setExclusiveStartKey(java.util.Map<String, AttributeValue> exclusiveStartKey) {
        this.exclusiveStartKey = exclusiveStartKey;
    }

    /**
     * <br>
     * The primary key of the first item that this operation will evaluate. Use the value that was returned for
     * <code>LastEvaluatedKey</code> in the previous operation.
     * <br>
     * <br>
     * The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are allowed.
     * <br>
     *
     * @param exclusiveStartKey
     *        The primary key of the first item that this operation will evaluate. Use the value that was returned for
     *        <code>LastEvaluatedKey</code> in the previous operation.<br>
     *        <br>
     *        The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are
     *        allowed.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withExclusiveStartKey(java.util.Map<String, AttributeValue> exclusiveStartKey) {
        setExclusiveStartKey(exclusiveStartKey);
        return this;
    }

    public QueryRequest addExclusiveStartKeyEntry(String key, AttributeValue value) {
        if (null == this.exclusiveStartKey) {
            this.exclusiveStartKey = new java.util.HashMap<String, AttributeValue>();
        }
        if (this.exclusiveStartKey.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.exclusiveStartKey.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ExclusiveStartKey.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest clearExclusiveStartKeyEntries() {
        this.exclusiveStartKey = null;
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

    public QueryRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
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

    public QueryRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
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

    public QueryRequest withProjectionExpression(String projectionExpression) {
        setProjectionExpression(projectionExpression);
        return this;
    }

    /**
     * <br>
     * A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
     * <br>
     * <br>
     * A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression based on a
     * partition key or a sort key.
     * <br>
     * <note>
     * <br>
     * A <code>FilterExpression</code> is applied after the items have already been read; the process of filtering does
     * not consume any additional read capacity units.
     * <br>
     * </note>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param filterExpression
     *        A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but before
     *        the data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not
     *        returned.<br>
     *        <br>
     *        A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression based
     *        on a partition key or a sort key.
     *        <br>
     *        <note>
     *        <br>
     *        A <code>FilterExpression</code> is applied after the items have already been read; the process of
     *        filtering does not consume any additional read capacity units.
     *        <br>
     *        </note>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults"
     *        >Filter Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
    }

    /**
     * <br>
     * A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
     * <br>
     * <br>
     * A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression based on a
     * partition key or a sort key.
     * <br>
     * <note>
     * <br>
     * A <code>FilterExpression</code> is applied after the items have already been read; the process of filtering does
     * not consume any additional read capacity units.
     * <br>
     * </note>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but
     *         before the data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria
     *         are not returned.<br>
     *         <br>
     *         A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression
     *         based on a partition key or a sort key.
     *         <br>
     *         <note>
     *         <br>
     *         A <code>FilterExpression</code> is applied after the items have already been read; the process of
     *         filtering does not consume any additional read capacity units.
     *         <br>
     *         </note>
     *         <br>
     *         For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults"
     *         >Filter Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public String getFilterExpression() {
        return this.filterExpression;
    }

    /**
     * <br>
     * A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
     * <br>
     * <br>
     * A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression based on a
     * partition key or a sort key.
     * <br>
     * <note>
     * <br>
     * A <code>FilterExpression</code> is applied after the items have already been read; the process of filtering does
     * not consume any additional read capacity units.
     * <br>
     * </note>
     * <br>
     * For more information, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults">Filter
     * Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param filterExpression
     *        A string that contains conditions that DynamoDB applies after the <code>Query</code> operation, but before
     *        the data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not
     *        returned.<br>
     *        <br>
     *        A <code>FilterExpression</code> does not allow key attributes. You cannot define a filter expression based
     *        on a partition key or a sort key.
     *        <br>
     *        <note>
     *        <br>
     *        A <code>FilterExpression</code> is applied after the items have already been read; the process of
     *        filtering does not consume any additional read capacity units.
     *        <br>
     *        </note>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/QueryAndScan.html#FilteringResults"
     *        >Filter Expressions</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withFilterExpression(String filterExpression) {
        setFilterExpression(filterExpression);
        return this;
    }

    /**
     * <br>
     * The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code> action.
     * <br>
     * <br>
     * The condition must perform an equality test on a single partition key value. The condition can also perform one
     * of several comparison tests on a single sort key value. <code>Query</code> can use
     * <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key value, or
     * several items that have the same partition key value but different sort key values.
     * <br>
     * <br>
     * The partition key equality test is required, and must be specified in the following format:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     * <br>
     * <br>
     * If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with the
     * condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the sort key:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     * <br>
     * <br>
     * Valid comparisons for the sort key condition are as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less than or
     * equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is greater than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is greater
     * than or equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     * <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to <code>:sortkeyval1</code>, and
     * less than or equal to <code>:sortkeyval2</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if the sort
     * key value begins with a particular operand. (You cannot use this function with a sort key that is of type
     * Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as <code>:partitionval</code> and
     * <code>:sortval</code> with actual values at runtime.
     * <br>
     * <br>
     * You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the partition
     * key and sort key with placeholder tokens. This option might be necessary if an attribute name conflicts with a
     * DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code> parameter causes an error
     * because <i>Size</i> is a reserved word:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Size = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name <i>Size</i>.
     * <code>KeyConditionExpression</code> then is as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#S = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For a list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     * Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param keyConditionExpression
     *        The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code>
     *        action.<br>
     *        <br>
     *        The condition must perform an equality test on a single partition key value. The condition can also
     *        perform one of several comparison tests on a single sort key value. <code>Query</code> can use
     *        <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key
     *        value, or several items that have the same partition key value but different sort key values.
     *        <br>
     *        <br>
     *        The partition key equality test is required, and must be specified in the following format:
     *        <br>
     *        <br>
     *        <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     *        <br>
     *        <br>
     *        If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with
     *        the condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the
     *        sort key:
     *        <br>
     *        <br>
     *        <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     *        <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     *        <br>
     *        <br>
     *        Valid comparisons for the sort key condition are as follows:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     *        <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less
     *        than <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less
     *        than or equal to <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is
     *        greater than <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is
     *        greater than or equal to <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     *        <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to
     *        <code>:sortkeyval1</code>, and less than or equal to <code>:sortkeyval2</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if the
     *        sort key value begins with a particular operand. (You cannot use this function with a sort key that is of
     *        type Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as
     *        <code>:partitionval</code> and <code>:sortval</code> with actual values at runtime.
     *        <br>
     *        <br>
     *        You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the
     *        partition key and sort key with placeholder tokens. This option might be necessary if an attribute name
     *        conflicts with a DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code>
     *        parameter causes an error because <i>Size</i> is a reserved word:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Size = :myval</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name
     *        <i>Size</i>. <code>KeyConditionExpression</code> then is as follows:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>#S = :myval</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        For a list of reserved words, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *        Words</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>,
     *        see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     *        Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setKeyConditionExpression(String keyConditionExpression) {
        this.keyConditionExpression = keyConditionExpression;
    }

    /**
     * <br>
     * The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code> action.
     * <br>
     * <br>
     * The condition must perform an equality test on a single partition key value. The condition can also perform one
     * of several comparison tests on a single sort key value. <code>Query</code> can use
     * <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key value, or
     * several items that have the same partition key value but different sort key values.
     * <br>
     * <br>
     * The partition key equality test is required, and must be specified in the following format:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     * <br>
     * <br>
     * If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with the
     * condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the sort key:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     * <br>
     * <br>
     * Valid comparisons for the sort key condition are as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less than or
     * equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is greater than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is greater
     * than or equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     * <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to <code>:sortkeyval1</code>, and
     * less than or equal to <code>:sortkeyval2</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if the sort
     * key value begins with a particular operand. (You cannot use this function with a sort key that is of type
     * Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as <code>:partitionval</code> and
     * <code>:sortval</code> with actual values at runtime.
     * <br>
     * <br>
     * You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the partition
     * key and sort key with placeholder tokens. This option might be necessary if an attribute name conflicts with a
     * DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code> parameter causes an error
     * because <i>Size</i> is a reserved word:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Size = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name <i>Size</i>.
     * <code>KeyConditionExpression</code> then is as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#S = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For a list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     * Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code>
     *         action.<br>
     *         <br>
     *         The condition must perform an equality test on a single partition key value. The condition can also
     *         perform one of several comparison tests on a single sort key value. <code>Query</code> can use
     *         <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key
     *         value, or several items that have the same partition key value but different sort key values.
     *         <br>
     *         <br>
     *         The partition key equality test is required, and must be specified in the following format:
     *         <br>
     *         <br>
     *         <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     *         <br>
     *         <br>
     *         If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with
     *         the condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the
     *         sort key:
     *         <br>
     *         <br>
     *         <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     *         <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     *         <br>
     *         <br>
     *         Valid comparisons for the sort key condition are as follows:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     *         <code>:sortkeyval</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less
     *         than <code>:sortkeyval</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less
     *         than or equal to <code>:sortkeyval</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is
     *         greater than <code>:sortkeyval</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is
     *         greater than or equal to <code>:sortkeyval</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     *         <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to
     *         <code>:sortkeyval1</code>, and less than or equal to <code>:sortkeyval2</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if
     *         the sort key value begins with a particular operand. (You cannot use this function with a sort key that
     *         is of type Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as
     *         <code>:partitionval</code> and <code>:sortval</code> with actual values at runtime.
     *         <br>
     *         <br>
     *         You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the
     *         partition key and sort key with placeholder tokens. This option might be necessary if an attribute name
     *         conflicts with a DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code>
     *         parameter causes an error because <i>Size</i> is a reserved word:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>Size = :myval</code>
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name
     *         <i>Size</i>. <code>KeyConditionExpression</code> then is as follows:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>#S = :myval</code>
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         For a list of reserved words, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *         Words</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *         <br>
     *         <br>
     *         For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>,
     *         see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     *         Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public String getKeyConditionExpression() {
        return this.keyConditionExpression;
    }

    /**
     * <br>
     * The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code> action.
     * <br>
     * <br>
     * The condition must perform an equality test on a single partition key value. The condition can also perform one
     * of several comparison tests on a single sort key value. <code>Query</code> can use
     * <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key value, or
     * several items that have the same partition key value but different sort key values.
     * <br>
     * <br>
     * The partition key equality test is required, and must be specified in the following format:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     * <br>
     * <br>
     * If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with the
     * condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the sort key:
     * <br>
     * <br>
     * <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     * <br>
     * <br>
     * Valid comparisons for the sort key condition are as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less than or
     * equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is greater than
     * <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is greater
     * than or equal to <code>:sortkeyval</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     * <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to <code>:sortkeyval1</code>, and
     * less than or equal to <code>:sortkeyval2</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if the sort
     * key value begins with a particular operand. (You cannot use this function with a sort key that is of type
     * Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     * <br>
     * </li>
     * </ul>
     * <br>
     * Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as <code>:partitionval</code> and
     * <code>:sortval</code> with actual values at runtime.
     * <br>
     * <br>
     * You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the partition
     * key and sort key with placeholder tokens. This option might be necessary if an attribute name conflicts with a
     * DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code> parameter causes an error
     * because <i>Size</i> is a reserved word:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Size = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name <i>Size</i>.
     * <code>KeyConditionExpression</code> then is as follows:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>#S = :myval</code>
     * <br>
     * </li>
     * </ul>
     * <br>
     * For a list of reserved words, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved Words</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     * Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param keyConditionExpression
     *        The condition that specifies the key value(s) for items to be retrieved by the <code>Query</code>
     *        action.<br>
     *        <br>
     *        The condition must perform an equality test on a single partition key value. The condition can also
     *        perform one of several comparison tests on a single sort key value. <code>Query</code> can use
     *        <code>KeyConditionExpression</code> to retrieve one item with a given partition key value and sort key
     *        value, or several items that have the same partition key value but different sort key values.
     *        <br>
     *        <br>
     *        The partition key equality test is required, and must be specified in the following format:
     *        <br>
     *        <br>
     *        <code>partitionKeyName</code> <i>=</i> <code>:partitionkeyval</code>
     *        <br>
     *        <br>
     *        If you also want to provide a condition for the sort key, it must be combined using <code>AND</code> with
     *        the condition for the sort key. Following is an example, using the <b>=</b> comparison operator for the
     *        sort key:
     *        <br>
     *        <br>
     *        <code>partitionKeyName</code> <code>=</code> <code>:partitionkeyval</code> <code>AND</code>
     *        <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code>
     *        <br>
     *        <br>
     *        Valid comparisons for the sort key condition are as follows:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>=</code> <code>:sortkeyval</code> - true if the sort key value is equal to
     *        <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&lt;</code> <code>:sortkeyval</code> - true if the sort key value is less
     *        than <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&lt;=</code> <code>:sortkeyval</code> - true if the sort key value is less
     *        than or equal to <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&gt;</code> <code>:sortkeyval</code> - true if the sort key value is
     *        greater than <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>&gt;= </code> <code>:sortkeyval</code> - true if the sort key value is
     *        greater than or equal to <code>:sortkeyval</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>sortKeyName</code> <code>BETWEEN</code> <code>:sortkeyval1</code> <code>AND</code>
     *        <code>:sortkeyval2</code> - true if the sort key value is greater than or equal to
     *        <code>:sortkeyval1</code>, and less than or equal to <code>:sortkeyval2</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>begins_with (</code> <code>sortKeyName</code>, <code>:sortkeyval</code> <code>)</code> - true if the
     *        sort key value begins with a particular operand. (You cannot use this function with a sort key that is of
     *        type Number.) Note that the function name <code>begins_with</code> is case-sensitive.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        Use the <code>ExpressionAttributeValues</code> parameter to replace tokens such as
     *        <code>:partitionval</code> and <code>:sortval</code> with actual values at runtime.
     *        <br>
     *        <br>
     *        You can optionally use the <code>ExpressionAttributeNames</code> parameter to replace the names of the
     *        partition key and sort key with placeholder tokens. This option might be necessary if an attribute name
     *        conflicts with a DynamoDB reserved word. For example, the following <code>KeyConditionExpression</code>
     *        parameter causes an error because <i>Size</i> is a reserved word:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Size = :myval</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        To work around this, define a placeholder (such a <code>#S</code>) to represent the attribute name
     *        <i>Size</i>. <code>KeyConditionExpression</code> then is as follows:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>#S = :myval</code>
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        For a list of reserved words, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ReservedWords.html">Reserved
     *        Words</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *        <br>
     *        <br>
     *        For more information on <code>ExpressionAttributeNames</code> and <code>ExpressionAttributeValues</code>,
     *        see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/ExpressionPlaceholders.html">Using
     *        Placeholders for Attribute Names and Values</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public QueryRequest withKeyConditionExpression(String keyConditionExpression) {
        setKeyConditionExpression(keyConditionExpression);
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

    public QueryRequest withExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    public QueryRequest addExpressionAttributeNamesEntry(String key, String value) {
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

    public QueryRequest clearExpressionAttributeNamesEntries() {
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

    public QueryRequest withExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    public QueryRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
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

    public QueryRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    /**
     * The primary hash and range keys of the first item that this operation will evaluate. Use the value that was
     * returned for <i>LastEvaluatedKey</i> in the previous operation.
     * <br>
     * The data type for <i>ExclusiveStartKey</i> must be String, Number or Binary. No set data types are allowed.
     *
     * @param hashKey
     *        a map entry including the name and value of the primary hash key.
     * @param rangeKey
     *        a map entry including the name and value of the primary range key, or null if it is a hash-only table.
     */
    public void setExclusiveStartKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        java.util.HashMap<String, AttributeValue> exclusiveStartKey = new java.util.HashMap<String, AttributeValue>();
        if (hashKey != null) {
            exclusiveStartKey.put(hashKey.getKey(), hashKey.getValue());
        } else {
            throw new IllegalArgumentException("hashKey must be non-null object.");
        }
        if (rangeKey != null) {
            exclusiveStartKey.put(rangeKey.getKey(), rangeKey.getValue());
        }
        setExclusiveStartKey(exclusiveStartKey);
    }

    /**
     * The primary hash and range keys of the first item that this operation will evaluate. Use the value that was
     * returned for <i>LastEvaluatedKey</i> in the previous operation.
     * <br>
     * The data type for <i>ExclusiveStartKey</i> must be String, Number or Binary. No set data types are allowed.
     * <br>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param hashKey
     *        a map entry including the name and value of the primary hash key.
     * @param rangeKey
     *        a map entry including the name and value of the primary range key, or null if it is a hash-only table.
     */
    public QueryRequest withExclusiveStartKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        setExclusiveStartKey(hashKey, rangeKey);
        return this;
    }
}
