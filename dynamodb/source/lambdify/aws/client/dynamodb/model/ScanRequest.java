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
 * Represents the input of a <code>Scan</code> operation.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/Scan" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class ScanRequest implements Serializable {

    /**
     * <br>
     * The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name of the
     * table to which that index belongs.
     * <br>
     */
    @JsonProperty("TableName")
    private String tableName;
    /**
     * <br>
     * The name of a secondary index to scan. This index can be any local secondary index or global secondary index.
     * Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName</code>.
     * <br>
     */
    @JsonProperty("IndexName")
    private String indexName;
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
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     * >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("ScanFilter")
    private java.util.Map<String, Condition> scanFilter;
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
     * The primary key of the first item that this operation will evaluate. Use the value that was returned for
     * <code>LastEvaluatedKey</code> in the previous operation.
     * <br>
     * <br>
     * The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are allowed.
     * <br>
     * <br>
     * In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify the
     * same segment whose previous <code>Scan</code> returned the corresponding value of <code>LastEvaluatedKey</code>.
     * <br>
     */
    @JsonProperty("ExclusiveStartKey")
    private java.util.Map<String, AttributeValue> exclusiveStartKey;

    @JsonProperty("ReturnConsumedCapacity")
    private String returnConsumedCapacity;
    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of segments into
     * which the <code>Scan</code> operation will be divided. The value of <code>TotalSegments</code> corresponds to the
     * number of application workers that will perform the parallel scan. For example, if you want to use four
     * application threads to scan a table or an index, specify a <code>TotalSegments</code> value of 4.
     * <br>
     * <br>
     * The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to 1000000.
     * If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be sequential rather
     * than parallel.
     * <br>
     * <br>
     * If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     * <br>
     */
    @JsonProperty("TotalSegments")
    private Integer totalSegments;
    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be scanned by
     * an application worker.
     * <br>
     * <br>
     * Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four application
     * threads to scan a table or an index, then the first thread specifies a <code>Segment</code> value of 0, the
     * second thread specifies 1, and so on.
     * <br>
     * <br>
     * The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be used as
     * <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code> operation.
     * <br>
     * <br>
     * The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided for
     * <code>TotalSegments</code>.
     * <br>
     * <br>
     * If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     * <br>
     */
    @JsonProperty("Segment")
    private Integer segment;
    /**
     * <br>
     * A string that identifies one or more attributes to retrieve from the specified table or index. These attributes
     * can include scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     * commas.
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
     * A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
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
     * <br>
     * A Boolean value that determines the read consistency model during the scan:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might not
     * contain the results from other recently completed write operations (PutItem, UpdateItem or DeleteItem).
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed before the
     * <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>ConsistentRead</code> is <code>false</code>.
     * <br>
     * <br>
     * The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a global
     * secondary index with <code>ConsistentRead</code> set to true, you will receive a <code>ValidationException</code>
     * .
     * <br>
     */
    @JsonProperty("ConsistentRead")
    private Boolean consistentRead;

    /**
     * Default constructor for ScanRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize the object after creating it.
     */
    public ScanRequest() {
    }

    /**
     * Constructs a new ScanRequest object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param tableName
     *        The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name
     *        of the table to which that index belongs.
     */
    public ScanRequest(String tableName) {
        setTableName(tableName);
    }

    /**
     * <br>
     * The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name of the
     * table to which that index belongs.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name
     *        of the table to which that index belongs.
     */

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * <br>
     * The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name of the
     * table to which that index belongs.
     * <br>
     *
     * @return The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name
     *         of the table to which that index belongs.
     */

    public String getTableName() {
        return this.tableName;
    }

    /**
     * <br>
     * The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name of the
     * table to which that index belongs.
     * <br>
     *
     * @param tableName
     *        The name of the table containing the requested items; or, if you provide <code>IndexName</code>, the name
     *        of the table to which that index belongs.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withTableName(String tableName) {
        setTableName(tableName);
        return this;
    }

    /**
     * <br>
     * The name of a secondary index to scan. This index can be any local secondary index or global secondary index.
     * Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName</code>.
     * <br>
     *
     * @param indexName
     *        The name of a secondary index to scan. This index can be any local secondary index or global secondary
     *        index. Note that if you use the <code>IndexName</code> parameter, you must also provide
     *        <code>TableName</code>.
     */

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    /**
     * <br>
     * The name of a secondary index to scan. This index can be any local secondary index or global secondary index.
     * Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName</code>.
     * <br>
     *
     * @return The name of a secondary index to scan. This index can be any local secondary index or global secondary
     *         index. Note that if you use the <code>IndexName</code> parameter, you must also provide
     *         <code>TableName</code>.
     */

    public String getIndexName() {
        return this.indexName;
    }

    /**
     * <br>
     * The name of a secondary index to scan. This index can be any local secondary index or global secondary index.
     * Note that if you use the <code>IndexName</code> parameter, you must also provide <code>TableName</code>.
     * <br>
     *
     * @param indexName
     *        The name of a secondary index to scan. This index can be any local secondary index or global secondary
     *        index. Note that if you use the <code>IndexName</code> parameter, you must also provide
     *        <code>TableName</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withIndexName(String indexName) {
        setIndexName(indexName);
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

    public ScanRequest withAttributesToGet(String... attributesToGet) {
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

    public ScanRequest withAttributesToGet(java.util.Collection<String> attributesToGet) {
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

    public ScanRequest withLimit(Integer limit) {
        setLimit(limit);
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

    public ScanRequest withSelect(String select) {
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

    public ScanRequest withSelect(Select select) {
        setSelect(select);
        return this;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     * >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     *         >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.Map<String, Condition> getScanFilter() {
        return scanFilter;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     * >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param scanFilter
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     *        >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setScanFilter(java.util.Map<String, Condition> scanFilter) {
        this.scanFilter = scanFilter;
    }

    /**
     * <br>
     * This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     * >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param scanFilter
     *        This is a legacy parameter. Use <code>FilterExpression</code> instead. For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/LegacyConditionalParameters.ScanFilter.html"
     *        >ScanFilter</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withScanFilter(java.util.Map<String, Condition> scanFilter) {
        setScanFilter(scanFilter);
        return this;
    }

    public ScanRequest addScanFilterEntry(String key, Condition value) {
        if (null == this.scanFilter) {
            this.scanFilter = new java.util.HashMap<String, Condition>();
        }
        if (this.scanFilter.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        this.scanFilter.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into ScanFilter.
     *
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest clearScanFilterEntries() {
        this.scanFilter = null;
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

    public ScanRequest withConditionalOperator(String conditionalOperator) {
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

    public ScanRequest withConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * <br>
     * The primary key of the first item that this operation will evaluate. Use the value that was returned for
     * <code>LastEvaluatedKey</code> in the previous operation.
     * <br>
     * <br>
     * The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are allowed.
     * <br>
     * <br>
     * In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify the
     * same segment whose previous <code>Scan</code> returned the corresponding value of <code>LastEvaluatedKey</code>.
     * <br>
     *
     * @return The primary key of the first item that this operation will evaluate. Use the value that was returned for
     *         <code>LastEvaluatedKey</code> in the previous operation.<br>
     *         <br>
     *         The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are
     *         allowed.
     *         <br>
     *         <br>
     *         In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify
     *         the same segment whose previous <code>Scan</code> returned the corresponding value of
     *         <code>LastEvaluatedKey</code>.
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
     * <br>
     * In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify the
     * same segment whose previous <code>Scan</code> returned the corresponding value of <code>LastEvaluatedKey</code>.
     * <br>
     *
     * @param exclusiveStartKey
     *        The primary key of the first item that this operation will evaluate. Use the value that was returned for
     *        <code>LastEvaluatedKey</code> in the previous operation.<br>
     *        <br>
     *        The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are
     *        allowed.
     *        <br>
     *        <br>
     *        In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify
     *        the same segment whose previous <code>Scan</code> returned the corresponding value of
     *        <code>LastEvaluatedKey</code>.
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
     * <br>
     * In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify the
     * same segment whose previous <code>Scan</code> returned the corresponding value of <code>LastEvaluatedKey</code>.
     * <br>
     *
     * @param exclusiveStartKey
     *        The primary key of the first item that this operation will evaluate. Use the value that was returned for
     *        <code>LastEvaluatedKey</code> in the previous operation.<br>
     *        <br>
     *        The data type for <code>ExclusiveStartKey</code> must be String, Number or Binary. No set data types are
     *        allowed.
     *        <br>
     *        <br>
     *        In a parallel scan, a <code>Scan</code> request that includes <code>ExclusiveStartKey</code> must specify
     *        the same segment whose previous <code>Scan</code> returned the corresponding value of
     *        <code>LastEvaluatedKey</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withExclusiveStartKey(java.util.Map<String, AttributeValue> exclusiveStartKey) {
        setExclusiveStartKey(exclusiveStartKey);
        return this;
    }

    public ScanRequest addExclusiveStartKeyEntry(String key, AttributeValue value) {
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

    public ScanRequest clearExclusiveStartKeyEntries() {
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

    public ScanRequest withReturnConsumedCapacity(String returnConsumedCapacity) {
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

    public ScanRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity) {
        setReturnConsumedCapacity(returnConsumedCapacity);
        return this;
    }

    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of segments into
     * which the <code>Scan</code> operation will be divided. The value of <code>TotalSegments</code> corresponds to the
     * number of application workers that will perform the parallel scan. For example, if you want to use four
     * application threads to scan a table or an index, specify a <code>TotalSegments</code> value of 4.
     * <br>
     * <br>
     * The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to 1000000.
     * If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be sequential rather
     * than parallel.
     * <br>
     * <br>
     * If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     * <br>
     *
     * @param totalSegments
     *        For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of
     *        segments into which the <code>Scan</code> operation will be divided. The value of
     *        <code>TotalSegments</code> corresponds to the number of application workers that will perform the parallel
     *        scan. For example, if you want to use four application threads to scan a table or an index, specify a
     *        <code>TotalSegments</code> value of 4.<br>
     *        <br>
     *        The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to
     *        1000000. If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be
     *        sequential rather than parallel.
     *        <br>
     *        <br>
     *        If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     */

    public void setTotalSegments(Integer totalSegments) {
        this.totalSegments = totalSegments;
    }

    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of segments into
     * which the <code>Scan</code> operation will be divided. The value of <code>TotalSegments</code> corresponds to the
     * number of application workers that will perform the parallel scan. For example, if you want to use four
     * application threads to scan a table or an index, specify a <code>TotalSegments</code> value of 4.
     * <br>
     * <br>
     * The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to 1000000.
     * If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be sequential rather
     * than parallel.
     * <br>
     * <br>
     * If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     * <br>
     *
     * @return For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of
     *         segments into which the <code>Scan</code> operation will be divided. The value of
     *         <code>TotalSegments</code> corresponds to the number of application workers that will perform the
     *         parallel scan. For example, if you want to use four application threads to scan a table or an index,
     *         specify a <code>TotalSegments</code> value of 4.<br>
     *         <br>
     *         The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to
     *         1000000. If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be
     *         sequential rather than parallel.
     *         <br>
     *         <br>
     *         If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     */

    public Integer getTotalSegments() {
        return this.totalSegments;
    }

    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of segments into
     * which the <code>Scan</code> operation will be divided. The value of <code>TotalSegments</code> corresponds to the
     * number of application workers that will perform the parallel scan. For example, if you want to use four
     * application threads to scan a table or an index, specify a <code>TotalSegments</code> value of 4.
     * <br>
     * <br>
     * The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to 1000000.
     * If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be sequential rather
     * than parallel.
     * <br>
     * <br>
     * If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     * <br>
     *
     * @param totalSegments
     *        For a parallel <code>Scan</code> request, <code>TotalSegments</code> represents the total number of
     *        segments into which the <code>Scan</code> operation will be divided. The value of
     *        <code>TotalSegments</code> corresponds to the number of application workers that will perform the parallel
     *        scan. For example, if you want to use four application threads to scan a table or an index, specify a
     *        <code>TotalSegments</code> value of 4.<br>
     *        <br>
     *        The value for <code>TotalSegments</code> must be greater than or equal to 1, and less than or equal to
     *        1000000. If you specify a <code>TotalSegments</code> value of 1, the <code>Scan</code> operation will be
     *        sequential rather than parallel.
     *        <br>
     *        <br>
     *        If you specify <code>TotalSegments</code>, you must also specify <code>Segment</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withTotalSegments(Integer totalSegments) {
        setTotalSegments(totalSegments);
        return this;
    }

    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be scanned by
     * an application worker.
     * <br>
     * <br>
     * Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four application
     * threads to scan a table or an index, then the first thread specifies a <code>Segment</code> value of 0, the
     * second thread specifies 1, and so on.
     * <br>
     * <br>
     * The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be used as
     * <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code> operation.
     * <br>
     * <br>
     * The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided for
     * <code>TotalSegments</code>.
     * <br>
     * <br>
     * If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     * <br>
     *
     * @param segment
     *        For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be
     *        scanned by an application worker.<br>
     *        <br>
     *        Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four
     *        application threads to scan a table or an index, then the first thread specifies a <code>Segment</code>
     *        value of 0, the second thread specifies 1, and so on.
     *        <br>
     *        <br>
     *        The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be used
     *        as <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code> operation.
     *        <br>
     *        <br>
     *        The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided
     *        for <code>TotalSegments</code>.
     *        <br>
     *        <br>
     *        If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     */

    public void setSegment(Integer segment) {
        this.segment = segment;
    }

    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be scanned by
     * an application worker.
     * <br>
     * <br>
     * Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four application
     * threads to scan a table or an index, then the first thread specifies a <code>Segment</code> value of 0, the
     * second thread specifies 1, and so on.
     * <br>
     * <br>
     * The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be used as
     * <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code> operation.
     * <br>
     * <br>
     * The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided for
     * <code>TotalSegments</code>.
     * <br>
     * <br>
     * If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     * <br>
     *
     * @return For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be
     *         scanned by an application worker.<br>
     *         <br>
     *         Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four
     *         application threads to scan a table or an index, then the first thread specifies a <code>Segment</code>
     *         value of 0, the second thread specifies 1, and so on.
     *         <br>
     *         <br>
     *         The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be
     *         used as <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code>
     *         operation.
     *         <br>
     *         <br>
     *         The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided
     *         for <code>TotalSegments</code>.
     *         <br>
     *         <br>
     *         If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     */

    public Integer getSegment() {
        return this.segment;
    }

    /**
     * <br>
     * For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be scanned by
     * an application worker.
     * <br>
     * <br>
     * Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four application
     * threads to scan a table or an index, then the first thread specifies a <code>Segment</code> value of 0, the
     * second thread specifies 1, and so on.
     * <br>
     * <br>
     * The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be used as
     * <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code> operation.
     * <br>
     * <br>
     * The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided for
     * <code>TotalSegments</code>.
     * <br>
     * <br>
     * If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     * <br>
     *
     * @param segment
     *        For a parallel <code>Scan</code> request, <code>Segment</code> identifies an individual segment to be
     *        scanned by an application worker.<br>
     *        <br>
     *        Segment IDs are zero-based, so the first segment is always 0. For example, if you want to use four
     *        application threads to scan a table or an index, then the first thread specifies a <code>Segment</code>
     *        value of 0, the second thread specifies 1, and so on.
     *        <br>
     *        <br>
     *        The value of <code>LastEvaluatedKey</code> returned from a parallel <code>Scan</code> request must be used
     *        as <code>ExclusiveStartKey</code> with the same segment ID in a subsequent <code>Scan</code> operation.
     *        <br>
     *        <br>
     *        The value for <code>Segment</code> must be greater than or equal to 0, and less than the value provided
     *        for <code>TotalSegments</code>.
     *        <br>
     *        <br>
     *        If you provide <code>Segment</code>, you must also provide <code>TotalSegments</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withSegment(Integer segment) {
        setSegment(segment);
        return this;
    }

    /**
     * <br>
     * A string that identifies one or more attributes to retrieve from the specified table or index. These attributes
     * can include scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     * commas.
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
     *        A string that identifies one or more attributes to retrieve from the specified table or index. These
     *        attributes can include scalars, sets, or elements of a JSON document. The attributes in the expression
     *        must be separated by commas.<br>
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
     * A string that identifies one or more attributes to retrieve from the specified table or index. These attributes
     * can include scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     * commas.
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
     * @return A string that identifies one or more attributes to retrieve from the specified table or index. These
     *         attributes can include scalars, sets, or elements of a JSON document. The attributes in the expression
     *         must be separated by commas.<br>
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
     * A string that identifies one or more attributes to retrieve from the specified table or index. These attributes
     * can include scalars, sets, or elements of a JSON document. The attributes in the expression must be separated by
     * commas.
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
     *        A string that identifies one or more attributes to retrieve from the specified table or index. These
     *        attributes can include scalars, sets, or elements of a JSON document. The attributes in the expression
     *        must be separated by commas.<br>
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

    public ScanRequest withProjectionExpression(String projectionExpression) {
        setProjectionExpression(projectionExpression);
        return this;
    }

    /**
     * <br>
     * A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
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
     *        A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before
     *        the data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not
     *        returned.</p> <note>
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
     * A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
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
     * @return A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before
     *         the data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not
     *         returned.</p> <note>
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
     * A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before the
     * data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not returned.
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
     *        A string that contains conditions that DynamoDB applies after the <code>Scan</code> operation, but before
     *        the data is returned to you. Items that do not satisfy the <code>FilterExpression</code> criteria are not
     *        returned.</p> <note>
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

    public ScanRequest withFilterExpression(String filterExpression) {
        setFilterExpression(filterExpression);
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

    public ScanRequest withExpressionAttributeNames(java.util.Map<String, String> expressionAttributeNames) {
        setExpressionAttributeNames(expressionAttributeNames);
        return this;
    }

    public ScanRequest addExpressionAttributeNamesEntry(String key, String value) {
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

    public ScanRequest clearExpressionAttributeNamesEntries() {
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

    public ScanRequest withExpressionAttributeValues(java.util.Map<String, AttributeValue> expressionAttributeValues) {
        setExpressionAttributeValues(expressionAttributeValues);
        return this;
    }

    public ScanRequest addExpressionAttributeValuesEntry(String key, AttributeValue value) {
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

    public ScanRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    /**
     * <br>
     * A Boolean value that determines the read consistency model during the scan:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might not
     * contain the results from other recently completed write operations (PutItem, UpdateItem or DeleteItem).
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed before the
     * <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>ConsistentRead</code> is <code>false</code>.
     * <br>
     * <br>
     * The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a global
     * secondary index with <code>ConsistentRead</code> set to true, you will receive a <code>ValidationException</code>
     * .
     * <br>
     *
     * @param consistentRead
     *        A Boolean value that determines the read consistency model during the scan:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might
     *        not contain the results from other recently completed write operations (PutItem, UpdateItem or
     *        DeleteItem).
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed
     *        before the <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The default setting for <code>ConsistentRead</code> is <code>false</code>.
     *        <br>
     *        <br>
     *        The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a
     *        global secondary index with <code>ConsistentRead</code> set to true, you will receive a
     *        <code>ValidationException</code>.
     */

    public void setConsistentRead(Boolean consistentRead) {
        this.consistentRead = consistentRead;
    }

    /**
     * <br>
     * A Boolean value that determines the read consistency model during the scan:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might not
     * contain the results from other recently completed write operations (PutItem, UpdateItem or DeleteItem).
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed before the
     * <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>ConsistentRead</code> is <code>false</code>.
     * <br>
     * <br>
     * The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a global
     * secondary index with <code>ConsistentRead</code> set to true, you will receive a <code>ValidationException</code>
     * .
     * <br>
     *
     * @return A Boolean value that determines the read consistency model during the scan:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might
     *         not contain the results from other recently completed write operations (PutItem, UpdateItem or
     *         DeleteItem).
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed
     *         before the <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         The default setting for <code>ConsistentRead</code> is <code>false</code>.
     *         <br>
     *         <br>
     *         The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a
     *         global secondary index with <code>ConsistentRead</code> set to true, you will receive a
     *         <code>ValidationException</code>.
     */

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    /**
     * <br>
     * A Boolean value that determines the read consistency model during the scan:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might not
     * contain the results from other recently completed write operations (PutItem, UpdateItem or DeleteItem).
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed before the
     * <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>ConsistentRead</code> is <code>false</code>.
     * <br>
     * <br>
     * The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a global
     * secondary index with <code>ConsistentRead</code> set to true, you will receive a <code>ValidationException</code>
     * .
     * <br>
     *
     * @param consistentRead
     *        A Boolean value that determines the read consistency model during the scan:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might
     *        not contain the results from other recently completed write operations (PutItem, UpdateItem or
     *        DeleteItem).
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed
     *        before the <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The default setting for <code>ConsistentRead</code> is <code>false</code>.
     *        <br>
     *        <br>
     *        The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a
     *        global secondary index with <code>ConsistentRead</code> set to true, you will receive a
     *        <code>ValidationException</code>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScanRequest withConsistentRead(Boolean consistentRead) {
        setConsistentRead(consistentRead);
        return this;
    }

    /**
     * <br>
     * A Boolean value that determines the read consistency model during the scan:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might not
     * contain the results from other recently completed write operations (PutItem, UpdateItem or DeleteItem).
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed before the
     * <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>ConsistentRead</code> is <code>false</code>.
     * <br>
     * <br>
     * The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a global
     * secondary index with <code>ConsistentRead</code> set to true, you will receive a <code>ValidationException</code>
     * .
     * <br>
     *
     * @return A Boolean value that determines the read consistency model during the scan:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         If <code>ConsistentRead</code> is <code>false</code>, then the data returned from <code>Scan</code> might
     *         not contain the results from other recently completed write operations (PutItem, UpdateItem or
     *         DeleteItem).
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         If <code>ConsistentRead</code> is <code>true</code>, then all of the write operations that completed
     *         before the <code>Scan</code> began are guaranteed to be contained in the <code>Scan</code> response.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         The default setting for <code>ConsistentRead</code> is <code>false</code>.
     *         <br>
     *         <br>
     *         The <code>ConsistentRead</code> parameter is not supported on global secondary indexes. If you scan a
     *         global secondary index with <code>ConsistentRead</code> set to true, you will receive a
     *         <code>ValidationException</code>.
     */

    public Boolean isConsistentRead() {
        return this.consistentRead;
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
    public ScanRequest withExclusiveStartKey(java.util.Map.Entry<String, AttributeValue> hashKey, java.util.Map.Entry<String, AttributeValue> rangeKey)
            throws IllegalArgumentException {
        setExclusiveStartKey(hashKey, rangeKey);
        return this;
    }
}
