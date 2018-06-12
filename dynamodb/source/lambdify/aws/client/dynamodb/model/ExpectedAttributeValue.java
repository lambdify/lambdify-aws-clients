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
 * Represents a condition to be compared with an attribute value. This condition can be used with
 * <code>DeleteItem</code>, <code>PutItem</code> or <code>UpdateItem</code> operations; if the comparison evaluates to
 * true, the operation succeeds; if not, the operation fails. You can use <code>ExpectedAttributeValue</code> in one of
 * two different ways:
 * <br>
 * <ul>
 * <li>
 * <br>
 * Use <code>AttributeValueList</code> to specify one or more values to compare against an attribute. Use
 * <code>ComparisonOperator</code> to specify how you want to perform the comparison. If the comparison evaluates to
 * true, then the conditional operation succeeds.
 * <br>
 * </li>
 * <li>
 * <br>
 * Use <code>Value</code> to specify a value that DynamoDB will compare against an attribute. If the values match, then
 * <code>ExpectedAttributeValue</code> evaluates to true and the conditional operation succeeds. Optionally, you can
 * also set <code>Exists</code> to false, indicating that you <i>do not</i> expect to find the attribute value in the
 * table. In this case, the conditional operation succeeds only if the comparison evaluates to false.
 * <br>
 * </li>
 * </ul>
 * <br>
 * <code>Value</code> and <code>Exists</code> are incompatible with <code>AttributeValueList</code> and
 * <code>ComparisonOperator</code>. Note that if you use both sets of parameters at once, DynamoDB will return a
 * <code>ValidationException</code> exception.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/ExpectedAttributeValue" target="_top">AWS
 *      API Documentation</a>
 */
@EqualsAndHashCode @ToString
public class ExpectedAttributeValue implements Serializable {

    /**
     * <br>
     * Represents the data for the expected attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("Value")
    private AttributeValue value;
    /**
     * <br>
     * Causes DynamoDB to evaluate the value before attempting a conditional operation:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already exists in
     * the table. If it is found, then the operation succeeds. If it is not found, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in the
     * table. If in fact the value does not exist, then the assumption is valid and the operation succeeds. If the value
     * is found, despite the assumption that it does not exist, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all by
     * itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to <code>true</code>,
     * because it is implied.
     * <br>
     * <br>
     * DynamoDB returns a <code>ValidationException</code> if:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value to
     * exist, but don't specify what that value is.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     * attribute to have a value, while also expecting it not to exist.)
     * <br>
     * </li>
     * </ul>
     */
    @JsonProperty("Exists")
    private Boolean exists;
    /**
     * <br>
     * A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals, greater than,
     * less than, etc.
     * <br>
     * <br>
     * The following comparison operators are available:
     * <br>
     * <br>
     * <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     * <br>
     * <br>
     * The following are descriptions of each comparison operator.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> element of a
     * different type than the one provided in the request, the value does not match. For example,
     * <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     * <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, Binary,
     * String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a different type
     * than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not
     * equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LE</code> : Less than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LT</code> : Less than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, or
     * Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than the
     * one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GE</code> : Greater than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GT</code> : Greater than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     * <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not relevant to
     * the <code>NOT_NULL</code> comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean <code>false</code>.
     * This is because the attribute "<code>a</code>" exists; its data type is not relevant to the <code>NULL</code>
     * comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is of type String, then the operator checks
     * for a substring match. If the target attribute of the comparison is of type Binary, then the operator looks for a
     * subsequence of the target that matches the input. If the target attribute of the comparison is a set ("
     * <code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it finds an
     * exact match with any member of the set.
     * <br>
     * <br>
     * CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is a String, then the operator checks for
     * the absence of a substring match. If the target attribute of the comparison is Binary, then the operator checks
     * for the absence of a subsequence of the target that matches the input. If the target attribute of the comparison
     * is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it
     * <i>does not</i> find an exact match with any member of the set.
     * <br>
     * <br>
     * NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BEGINS_WITH</code> : Checks for a prefix.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary (not a
     * Number or a set type). The target attribute of the comparison must be of type String or Binary (not a Number or a
     * set type).
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>IN</code> : Checks for matching elements in a list.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type String,
     * Number, or Binary. These attributes are compared against an existing attribute of an item. If any elements of the
     * input are equal to the item attribute, the expression evaluates to true.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second value.
     * <br>
     * <br>
     * <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type, either
     * String, Number, or Binary (not a set type). A target attribute matches if the target value is greater than, or
     * equal to, the first element and less than, or equal to, the second element. If an item contains an
     * <code>AttributeValue</code> element of a different type than the one provided in the request, the value does not
     * match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>. Also,
     * <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     * <br>
     * </li>
     * </ul>
     */
    @JsonProperty("ComparisonOperator")
    private String comparisonOperator;
    /**
     * <br>
     * One or more values to evaluate against the supplied attribute. The number of values in the list depends on the
     * <code>ComparisonOperator</code> being used.
     * <br>
     * <br>
     * For type Number, value comparisons are numeric.
     * <br>
     * <br>
     * String value comparisons for greater than, equals, or less than are based on ASCII character code values. For
     * example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than <code>B</code>. For a
     * list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia
     * .org/wiki/ASCII#ASCII_printable_characters</a>.
     * <br>
     * <br>
     * For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     * <br>
     * <br>
     * For information on specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data Format</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("AttributeValueList")
    private java.util.List<AttributeValue> attributeValueList;

    /**
     * Default constructor for ExpectedAttributeValue object. Callers should use the setter or fluent setter (with...)
     * methods to initialize the object after creating it.
     */
    public ExpectedAttributeValue() {
    }

    /**
     * Constructs a new ExpectedAttributeValue object. Callers should use the setter or fluent setter (with...) methods
     * to initialize any additional object members.
     * 
     * @param value
     *        Represents the data for the expected attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public ExpectedAttributeValue(AttributeValue value) {
        setValue(value);
    }

    /**
     * Constructs a new ExpectedAttributeValue object. Callers should use the setter or fluent setter (with...) methods
     * to initialize any additional object members.
     * 
     * @param exists
     *        Causes DynamoDB to evaluate the value before attempting a conditional operation:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already
     *        exists in the table. If it is found, then the operation succeeds. If it is not found, the operation fails
     *        with a <code>ConditionalCheckFailedException</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in
     *        the table. If in fact the value does not exist, then the assumption is valid and the operation succeeds.
     *        If the value is found, despite the assumption that it does not exist, the operation fails with a
     *        <code>ConditionalCheckFailedException</code>.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all
     *        by itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to
     *        <code>true</code>, because it is implied.
     *        <br>
     *        <br>
     *        DynamoDB returns a <code>ValidationException</code> if:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value
     *        to exist, but don't specify what that value is.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     *        attribute to have a value, while also expecting it not to exist.)
     *        <br>
     *        </li>
     *        </ul>
     */
    public ExpectedAttributeValue(Boolean exists) {
        setExists(exists);
    }

    /**
     * <br>
     * Represents the data for the expected attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param value
     *        Represents the data for the expected attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setValue(AttributeValue value) {
        this.value = value;
    }

    /**
     * <br>
     * Represents the data for the expected attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return Represents the data for the expected attribute.<br>
     *         <br>
     *         Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *         data itself.
     *         <br>
     *         <br>
     *         For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *         >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public AttributeValue getValue() {
        return this.value;
    }

    /**
     * <br>
     * Represents the data for the expected attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param value
     *        Represents the data for the expected attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ExpectedAttributeValue withValue(AttributeValue value) {
        setValue(value);
        return this;
    }

    /**
     * <br>
     * Causes DynamoDB to evaluate the value before attempting a conditional operation:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already exists in
     * the table. If it is found, then the operation succeeds. If it is not found, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in the
     * table. If in fact the value does not exist, then the assumption is valid and the operation succeeds. If the value
     * is found, despite the assumption that it does not exist, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all by
     * itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to <code>true</code>,
     * because it is implied.
     * <br>
     * <br>
     * DynamoDB returns a <code>ValidationException</code> if:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value to
     * exist, but don't specify what that value is.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     * attribute to have a value, while also expecting it not to exist.)
     * <br>
     * </li>
     * </ul>
     * 
     * @param exists
     *        Causes DynamoDB to evaluate the value before attempting a conditional operation:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already
     *        exists in the table. If it is found, then the operation succeeds. If it is not found, the operation fails
     *        with a <code>ConditionalCheckFailedException</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in
     *        the table. If in fact the value does not exist, then the assumption is valid and the operation succeeds.
     *        If the value is found, despite the assumption that it does not exist, the operation fails with a
     *        <code>ConditionalCheckFailedException</code>.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all
     *        by itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to
     *        <code>true</code>, because it is implied.
     *        <br>
     *        <br>
     *        DynamoDB returns a <code>ValidationException</code> if:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value
     *        to exist, but don't specify what that value is.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     *        attribute to have a value, while also expecting it not to exist.)
     *        <br>
     *        </li>
     *        </ul>
     */

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    /**
     * <br>
     * Causes DynamoDB to evaluate the value before attempting a conditional operation:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already exists in
     * the table. If it is found, then the operation succeeds. If it is not found, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in the
     * table. If in fact the value does not exist, then the assumption is valid and the operation succeeds. If the value
     * is found, despite the assumption that it does not exist, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all by
     * itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to <code>true</code>,
     * because it is implied.
     * <br>
     * <br>
     * DynamoDB returns a <code>ValidationException</code> if:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value to
     * exist, but don't specify what that value is.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     * attribute to have a value, while also expecting it not to exist.)
     * <br>
     * </li>
     * </ul>
     * 
     * @return Causes DynamoDB to evaluate the value before attempting a conditional operation:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already
     *         exists in the table. If it is found, then the operation succeeds. If it is not found, the operation fails
     *         with a <code>ConditionalCheckFailedException</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in
     *         the table. If in fact the value does not exist, then the assumption is valid and the operation succeeds.
     *         If the value is found, despite the assumption that it does not exist, the operation fails with a
     *         <code>ConditionalCheckFailedException</code>.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all
     *         by itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to
     *         <code>true</code>, because it is implied.
     *         <br>
     *         <br>
     *         DynamoDB returns a <code>ValidationException</code> if:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value
     *         to exist, but don't specify what that value is.)
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect
     *         an attribute to have a value, while also expecting it not to exist.)
     *         <br>
     *         </li>
     *        </ul>
     */

    public Boolean getExists() {
        return this.exists;
    }

    /**
     * <br>
     * Causes DynamoDB to evaluate the value before attempting a conditional operation:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already exists in
     * the table. If it is found, then the operation succeeds. If it is not found, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in the
     * table. If in fact the value does not exist, then the assumption is valid and the operation succeeds. If the value
     * is found, despite the assumption that it does not exist, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all by
     * itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to <code>true</code>,
     * because it is implied.
     * <br>
     * <br>
     * DynamoDB returns a <code>ValidationException</code> if:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value to
     * exist, but don't specify what that value is.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     * attribute to have a value, while also expecting it not to exist.)
     * <br>
     * </li>
     * </ul>
     * 
     * @param exists
     *        Causes DynamoDB to evaluate the value before attempting a conditional operation:<br>
     *        <ul>
     *        <li>
     *        <br>
     *        If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already
     *        exists in the table. If it is found, then the operation succeeds. If it is not found, the operation fails
     *        with a <code>ConditionalCheckFailedException</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in
     *        the table. If in fact the value does not exist, then the assumption is valid and the operation succeeds.
     *        If the value is found, despite the assumption that it does not exist, the operation fails with a
     *        <code>ConditionalCheckFailedException</code>.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all
     *        by itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to
     *        <code>true</code>, because it is implied.
     *        <br>
     *        <br>
     *        DynamoDB returns a <code>ValidationException</code> if:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value
     *        to exist, but don't specify what that value is.)
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     *        attribute to have a value, while also expecting it not to exist.)
     *        <br>
     *        </li>
     *        </ul>
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ExpectedAttributeValue withExists(Boolean exists) {
        setExists(exists);
        return this;
    }

    /**
     * <br>
     * Causes DynamoDB to evaluate the value before attempting a conditional operation:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already exists in
     * the table. If it is found, then the operation succeeds. If it is not found, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in the
     * table. If in fact the value does not exist, then the assumption is valid and the operation succeeds. If the value
     * is found, despite the assumption that it does not exist, the operation fails with a
     * <code>ConditionalCheckFailedException</code>.
     * <br>
     * </li>
     * </ul>
     * <br>
     * The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all by
     * itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to <code>true</code>,
     * because it is implied.
     * <br>
     * <br>
     * DynamoDB returns a <code>ValidationException</code> if:
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value to
     * exist, but don't specify what that value is.)
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect an
     * attribute to have a value, while also expecting it not to exist.)
     * <br>
     * </li>
     * </ul>
     * 
     * @return Causes DynamoDB to evaluate the value before attempting a conditional operation:<br>
     *         <ul>
     *         <li>
     *         <br>
     *         If <code>Exists</code> is <code>true</code>, DynamoDB will check to see if that attribute value already
     *         exists in the table. If it is found, then the operation succeeds. If it is not found, the operation fails
     *         with a <code>ConditionalCheckFailedException</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         If <code>Exists</code> is <code>false</code>, DynamoDB assumes that the attribute value does not exist in
     *         the table. If in fact the value does not exist, then the assumption is valid and the operation succeeds.
     *         If the value is found, despite the assumption that it does not exist, the operation fails with a
     *         <code>ConditionalCheckFailedException</code>.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         The default setting for <code>Exists</code> is <code>true</code>. If you supply a <code>Value</code> all
     *         by itself, DynamoDB assumes the attribute exists: You don't have to set <code>Exists</code> to
     *         <code>true</code>, because it is implied.
     *         <br>
     *         <br>
     *         DynamoDB returns a <code>ValidationException</code> if:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>Exists</code> is <code>true</code> but there is no <code>Value</code> to check. (You expect a value
     *         to exist, but don't specify what that value is.)
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>Exists</code> is <code>false</code> but you also provide a <code>Value</code>. (You cannot expect
     *         an attribute to have a value, while also expecting it not to exist.)
     *         <br>
     *         </li>
     *        </ul>
     */

    public Boolean isExists() {
        return this.exists;
    }

    /**
     * <br>
     * A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals, greater than,
     * less than, etc.
     * <br>
     * <br>
     * The following comparison operators are available:
     * <br>
     * <br>
     * <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     * <br>
     * <br>
     * The following are descriptions of each comparison operator.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> element of a
     * different type than the one provided in the request, the value does not match. For example,
     * <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     * <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, Binary,
     * String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a different type
     * than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not
     * equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LE</code> : Less than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LT</code> : Less than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, or
     * Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than the
     * one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GE</code> : Greater than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GT</code> : Greater than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     * <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not relevant to
     * the <code>NOT_NULL</code> comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean <code>false</code>.
     * This is because the attribute "<code>a</code>" exists; its data type is not relevant to the <code>NULL</code>
     * comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is of type String, then the operator checks
     * for a substring match. If the target attribute of the comparison is of type Binary, then the operator looks for a
     * subsequence of the target that matches the input. If the target attribute of the comparison is a set ("
     * <code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it finds an
     * exact match with any member of the set.
     * <br>
     * <br>
     * CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is a String, then the operator checks for
     * the absence of a substring match. If the target attribute of the comparison is Binary, then the operator checks
     * for the absence of a subsequence of the target that matches the input. If the target attribute of the comparison
     * is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it
     * <i>does not</i> find an exact match with any member of the set.
     * <br>
     * <br>
     * NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BEGINS_WITH</code> : Checks for a prefix.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary (not a
     * Number or a set type). The target attribute of the comparison must be of type String or Binary (not a Number or a
     * set type).
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>IN</code> : Checks for matching elements in a list.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type String,
     * Number, or Binary. These attributes are compared against an existing attribute of an item. If any elements of the
     * input are equal to the item attribute, the expression evaluates to true.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second value.
     * <br>
     * <br>
     * <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type, either
     * String, Number, or Binary (not a set type). A target attribute matches if the target value is greater than, or
     * equal to, the first element and less than, or equal to, the second element. If an item contains an
     * <code>AttributeValue</code> element of a different type than the one provided in the request, the value does not
     * match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>. Also,
     * <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     * <br>
     * </li>
     * </ul>
     * 
     * @param comparisonOperator
     *        A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals,
     *        greater than, less than, etc.<br>
     *        <br>
     *        The following comparison operators are available:
     *        <br>
     *        <br>
     *        <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     *        <br>
     *        <br>
     *        The following are descriptions of each comparison operator.
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code>
     *        element of a different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LE</code> : Less than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LT</code> : Less than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type
     *        than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does
     *        not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GE</code> : Greater than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GT</code> : Greater than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     *        <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     *        <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not
     *        relevant to the <code>NOT_NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute
     *        "<code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean
     *        <code>false</code>. This is because the attribute "<code>a</code>" exists; its data type is not relevant
     *        to the <code>NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is of type String, then the
     *        operator checks for a substring match. If the target attribute of the comparison is of type Binary, then
     *        the operator looks for a subsequence of the target that matches the input. If the target attribute of the
     *        comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator
     *        evaluates to true if it finds an exact match with any member of the set.
     *        <br>
     *        <br>
     *        CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is a String, then the
     *        operator checks for the absence of a substring match. If the target attribute of the comparison is Binary,
     *        then the operator checks for the absence of a subsequence of the target that matches the input. If the
     *        target attribute of the comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"),
     *        then the operator evaluates to true if it <i>does not</i> find an exact match with any member of the set.
     *        <br>
     *        <br>
     *        NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BEGINS_WITH</code> : Checks for a prefix.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary
     *        (not a Number or a set type). The target attribute of the comparison must be of type String or Binary (not
     *        a Number or a set type).
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>IN</code> : Checks for matching elements in a list.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type
     *        String, Number, or Binary. These attributes are compared against an existing attribute of an item. If any
     *        elements of the input are equal to the item attribute, the expression evaluates to true.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second
     *        value.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type,
     *        either String, Number, or Binary (not a set type). A target attribute matches if the target value is
     *        greater than, or equal to, the first element and less than, or equal to, the second element. If an item
     *        contains an <code>AttributeValue</code> element of a different type than the one provided in the request,
     *        the value does not match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>.
     *        Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     *        <br>
     *        </li>
     *        </ul>
     * @see ComparisonOperator
     */

    public void setComparisonOperator(String comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    /**
     * <br>
     * A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals, greater than,
     * less than, etc.
     * <br>
     * <br>
     * The following comparison operators are available:
     * <br>
     * <br>
     * <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     * <br>
     * <br>
     * The following are descriptions of each comparison operator.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> element of a
     * different type than the one provided in the request, the value does not match. For example,
     * <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     * <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, Binary,
     * String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a different type
     * than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not
     * equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LE</code> : Less than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LT</code> : Less than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, or
     * Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than the
     * one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GE</code> : Greater than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GT</code> : Greater than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     * <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not relevant to
     * the <code>NOT_NULL</code> comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean <code>false</code>.
     * This is because the attribute "<code>a</code>" exists; its data type is not relevant to the <code>NULL</code>
     * comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is of type String, then the operator checks
     * for a substring match. If the target attribute of the comparison is of type Binary, then the operator looks for a
     * subsequence of the target that matches the input. If the target attribute of the comparison is a set ("
     * <code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it finds an
     * exact match with any member of the set.
     * <br>
     * <br>
     * CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is a String, then the operator checks for
     * the absence of a substring match. If the target attribute of the comparison is Binary, then the operator checks
     * for the absence of a subsequence of the target that matches the input. If the target attribute of the comparison
     * is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it
     * <i>does not</i> find an exact match with any member of the set.
     * <br>
     * <br>
     * NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BEGINS_WITH</code> : Checks for a prefix.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary (not a
     * Number or a set type). The target attribute of the comparison must be of type String or Binary (not a Number or a
     * set type).
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>IN</code> : Checks for matching elements in a list.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type String,
     * Number, or Binary. These attributes are compared against an existing attribute of an item. If any elements of the
     * input are equal to the item attribute, the expression evaluates to true.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second value.
     * <br>
     * <br>
     * <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type, either
     * String, Number, or Binary (not a set type). A target attribute matches if the target value is greater than, or
     * equal to, the first element and less than, or equal to, the second element. If an item contains an
     * <code>AttributeValue</code> element of a different type than the one provided in the request, the value does not
     * match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>. Also,
     * <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     * <br>
     * </li>
     * </ul>
     * 
     * @return A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals,
     *         greater than, less than, etc.<br>
     *         <br>
     *         The following comparison operators are available:
     *         <br>
     *         <br>
     *         <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     *         <br>
     *         <br>
     *         The following are descriptions of each comparison operator.
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *         Number, Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code>
     *         element of a different type than the one provided in the request, the value does not match. For example,
     *         <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *         <code>{"NS":["6", "2", "1"]}</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *         Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a
     *         different type than the one provided in the request, the value does not match. For example,
     *         <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *         <code>{"NS":["6", "2", "1"]}</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>LE</code> : Less than or equal.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *         Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *         different type than the one provided in the request, the value does not match. For example,
     *         <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *         compare to <code>{"NS":["6", "2", "1"]}</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>LT</code> : Less than.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *         or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different
     *         type than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code>
     *         does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to
     *         <code>{"NS":["6", "2", "1"]}</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>GE</code> : Greater than or equal.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *         Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *         different type than the one provided in the request, the value does not match. For example,
     *         <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *         compare to <code>{"NS":["6", "2", "1"]}</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>GT</code> : Greater than.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *         Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *         different type than the one provided in the request, the value does not match. For example,
     *         <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *         compare to <code>{"NS":["6", "2", "1"]}</code>.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types,
     *         including lists and maps.
     *         <br>
     *         <note>
     *         <br>
     *         This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     *         <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     *         <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not
     *         relevant to the <code>NOT_NULL</code> comparison operator.
     *         <br>
     *         </note></li>
     *         <li>
     *         <br>
     *         <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types,
     *         including lists and maps.
     *         <br>
     *         <note>
     *         <br>
     *         This operator tests for the nonexistence of an attribute, not its data type. If the data type of
     *         attribute "<code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean
     *         <code>false</code>. This is because the attribute "<code>a</code>" exists; its data type is not relevant
     *         to the <code>NULL</code> comparison operator.
     *         <br>
     *         </note></li>
     *         <li>
     *         <br>
     *         <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *         Number, or Binary (not a set type). If the target attribute of the comparison is of type String, then the
     *         operator checks for a substring match. If the target attribute of the comparison is of type Binary, then
     *         the operator looks for a subsequence of the target that matches the input. If the target attribute of the
     *         comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator
     *         evaluates to true if it finds an exact match with any member of the set.
     *         <br>
     *         <br>
     *         CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     *         " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *         Number, or Binary (not a set type). If the target attribute of the comparison is a String, then the
     *         operator checks for the absence of a substring match. If the target attribute of the comparison is
     *         Binary, then the operator checks for the absence of a subsequence of the target that matches the input.
     *         If the target attribute of the comparison is a set ("<code>SS</code>", "<code>NS</code>", or "
     *         <code>BS</code>"), then the operator evaluates to true if it <i>does not</i> find an exact match with any
     *         member of the set.
     *         <br>
     *         <br>
     *         NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     *         " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>BEGINS_WITH</code> : Checks for a prefix.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary
     *         (not a Number or a set type). The target attribute of the comparison must be of type String or Binary
     *         (not a Number or a set type).
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>IN</code> : Checks for matching elements in a list.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type
     *         String, Number, or Binary. These attributes are compared against an existing attribute of an item. If any
     *         elements of the input are equal to the item attribute, the expression evaluates to true.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second
     *         value.
     *         <br>
     *         <br>
     *         <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type,
     *         either String, Number, or Binary (not a set type). A target attribute matches if the target value is
     *         greater than, or equal to, the first element and less than, or equal to, the second element. If an item
     *         contains an <code>AttributeValue</code> element of a different type than the one provided in the request,
     *         the value does not match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>.
     *         Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     *         <br>
     *         </li>
     *        </ul>
     * @see ComparisonOperator
     */

    public String getComparisonOperator() {
        return this.comparisonOperator;
    }

    /**
     * <br>
     * A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals, greater than,
     * less than, etc.
     * <br>
     * <br>
     * The following comparison operators are available:
     * <br>
     * <br>
     * <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     * <br>
     * <br>
     * The following are descriptions of each comparison operator.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> element of a
     * different type than the one provided in the request, the value does not match. For example,
     * <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     * <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, Binary,
     * String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a different type
     * than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not
     * equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LE</code> : Less than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LT</code> : Less than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, or
     * Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than the
     * one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GE</code> : Greater than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GT</code> : Greater than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     * <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not relevant to
     * the <code>NOT_NULL</code> comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean <code>false</code>.
     * This is because the attribute "<code>a</code>" exists; its data type is not relevant to the <code>NULL</code>
     * comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is of type String, then the operator checks
     * for a substring match. If the target attribute of the comparison is of type Binary, then the operator looks for a
     * subsequence of the target that matches the input. If the target attribute of the comparison is a set ("
     * <code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it finds an
     * exact match with any member of the set.
     * <br>
     * <br>
     * CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is a String, then the operator checks for
     * the absence of a substring match. If the target attribute of the comparison is Binary, then the operator checks
     * for the absence of a subsequence of the target that matches the input. If the target attribute of the comparison
     * is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it
     * <i>does not</i> find an exact match with any member of the set.
     * <br>
     * <br>
     * NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BEGINS_WITH</code> : Checks for a prefix.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary (not a
     * Number or a set type). The target attribute of the comparison must be of type String or Binary (not a Number or a
     * set type).
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>IN</code> : Checks for matching elements in a list.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type String,
     * Number, or Binary. These attributes are compared against an existing attribute of an item. If any elements of the
     * input are equal to the item attribute, the expression evaluates to true.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second value.
     * <br>
     * <br>
     * <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type, either
     * String, Number, or Binary (not a set type). A target attribute matches if the target value is greater than, or
     * equal to, the first element and less than, or equal to, the second element. If an item contains an
     * <code>AttributeValue</code> element of a different type than the one provided in the request, the value does not
     * match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>. Also,
     * <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     * <br>
     * </li>
     * </ul>
     * 
     * @param comparisonOperator
     *        A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals,
     *        greater than, less than, etc.<br>
     *        <br>
     *        The following comparison operators are available:
     *        <br>
     *        <br>
     *        <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     *        <br>
     *        <br>
     *        The following are descriptions of each comparison operator.
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code>
     *        element of a different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LE</code> : Less than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LT</code> : Less than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type
     *        than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does
     *        not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GE</code> : Greater than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GT</code> : Greater than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     *        <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     *        <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not
     *        relevant to the <code>NOT_NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute
     *        "<code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean
     *        <code>false</code>. This is because the attribute "<code>a</code>" exists; its data type is not relevant
     *        to the <code>NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is of type String, then the
     *        operator checks for a substring match. If the target attribute of the comparison is of type Binary, then
     *        the operator looks for a subsequence of the target that matches the input. If the target attribute of the
     *        comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator
     *        evaluates to true if it finds an exact match with any member of the set.
     *        <br>
     *        <br>
     *        CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is a String, then the
     *        operator checks for the absence of a substring match. If the target attribute of the comparison is Binary,
     *        then the operator checks for the absence of a subsequence of the target that matches the input. If the
     *        target attribute of the comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"),
     *        then the operator evaluates to true if it <i>does not</i> find an exact match with any member of the set.
     *        <br>
     *        <br>
     *        NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BEGINS_WITH</code> : Checks for a prefix.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary
     *        (not a Number or a set type). The target attribute of the comparison must be of type String or Binary (not
     *        a Number or a set type).
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>IN</code> : Checks for matching elements in a list.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type
     *        String, Number, or Binary. These attributes are compared against an existing attribute of an item. If any
     *        elements of the input are equal to the item attribute, the expression evaluates to true.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second
     *        value.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type,
     *        either String, Number, or Binary (not a set type). A target attribute matches if the target value is
     *        greater than, or equal to, the first element and less than, or equal to, the second element. If an item
     *        contains an <code>AttributeValue</code> element of a different type than the one provided in the request,
     *        the value does not match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>.
     *        Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     *        <br>
     *        </li>
     *        </ul>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ComparisonOperator
     */

    public ExpectedAttributeValue withComparisonOperator(String comparisonOperator) {
        setComparisonOperator(comparisonOperator);
        return this;
    }

    /**
     * <br>
     * A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals, greater than,
     * less than, etc.
     * <br>
     * <br>
     * The following comparison operators are available:
     * <br>
     * <br>
     * <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     * <br>
     * <br>
     * The following are descriptions of each comparison operator.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> element of a
     * different type than the one provided in the request, the value does not match. For example,
     * <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     * <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, Binary,
     * String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a different type
     * than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not
     * equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LE</code> : Less than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LT</code> : Less than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, or
     * Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than the
     * one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GE</code> : Greater than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GT</code> : Greater than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     * <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not relevant to
     * the <code>NOT_NULL</code> comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean <code>false</code>.
     * This is because the attribute "<code>a</code>" exists; its data type is not relevant to the <code>NULL</code>
     * comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is of type String, then the operator checks
     * for a substring match. If the target attribute of the comparison is of type Binary, then the operator looks for a
     * subsequence of the target that matches the input. If the target attribute of the comparison is a set ("
     * <code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it finds an
     * exact match with any member of the set.
     * <br>
     * <br>
     * CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is a String, then the operator checks for
     * the absence of a substring match. If the target attribute of the comparison is Binary, then the operator checks
     * for the absence of a subsequence of the target that matches the input. If the target attribute of the comparison
     * is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it
     * <i>does not</i> find an exact match with any member of the set.
     * <br>
     * <br>
     * NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BEGINS_WITH</code> : Checks for a prefix.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary (not a
     * Number or a set type). The target attribute of the comparison must be of type String or Binary (not a Number or a
     * set type).
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>IN</code> : Checks for matching elements in a list.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type String,
     * Number, or Binary. These attributes are compared against an existing attribute of an item. If any elements of the
     * input are equal to the item attribute, the expression evaluates to true.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second value.
     * <br>
     * <br>
     * <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type, either
     * String, Number, or Binary (not a set type). A target attribute matches if the target value is greater than, or
     * equal to, the first element and less than, or equal to, the second element. If an item contains an
     * <code>AttributeValue</code> element of a different type than the one provided in the request, the value does not
     * match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>. Also,
     * <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     * <br>
     * </li>
     * </ul>
     * 
     * @param comparisonOperator
     *        A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals,
     *        greater than, less than, etc.<br>
     *        <br>
     *        The following comparison operators are available:
     *        <br>
     *        <br>
     *        <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     *        <br>
     *        <br>
     *        The following are descriptions of each comparison operator.
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code>
     *        element of a different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LE</code> : Less than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LT</code> : Less than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type
     *        than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does
     *        not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GE</code> : Greater than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GT</code> : Greater than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     *        <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     *        <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not
     *        relevant to the <code>NOT_NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute
     *        "<code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean
     *        <code>false</code>. This is because the attribute "<code>a</code>" exists; its data type is not relevant
     *        to the <code>NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is of type String, then the
     *        operator checks for a substring match. If the target attribute of the comparison is of type Binary, then
     *        the operator looks for a subsequence of the target that matches the input. If the target attribute of the
     *        comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator
     *        evaluates to true if it finds an exact match with any member of the set.
     *        <br>
     *        <br>
     *        CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is a String, then the
     *        operator checks for the absence of a substring match. If the target attribute of the comparison is Binary,
     *        then the operator checks for the absence of a subsequence of the target that matches the input. If the
     *        target attribute of the comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"),
     *        then the operator evaluates to true if it <i>does not</i> find an exact match with any member of the set.
     *        <br>
     *        <br>
     *        NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BEGINS_WITH</code> : Checks for a prefix.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary
     *        (not a Number or a set type). The target attribute of the comparison must be of type String or Binary (not
     *        a Number or a set type).
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>IN</code> : Checks for matching elements in a list.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type
     *        String, Number, or Binary. These attributes are compared against an existing attribute of an item. If any
     *        elements of the input are equal to the item attribute, the expression evaluates to true.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second
     *        value.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type,
     *        either String, Number, or Binary (not a set type). A target attribute matches if the target value is
     *        greater than, or equal to, the first element and less than, or equal to, the second element. If an item
     *        contains an <code>AttributeValue</code> element of a different type than the one provided in the request,
     *        the value does not match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>.
     *        Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     *        <br>
     *        </li>
     *        </ul>
     * @see ComparisonOperator
     */

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
    }

    /**
     * <br>
     * A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals, greater than,
     * less than, etc.
     * <br>
     * <br>
     * The following comparison operators are available:
     * <br>
     * <br>
     * <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     * <br>
     * <br>
     * The following are descriptions of each comparison operator.
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> element of a
     * different type than the one provided in the request, the value does not match. For example,
     * <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     * <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, Binary,
     * String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a different type
     * than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not
     * equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LE</code> : Less than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>LT</code> : Less than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number, or
     * Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than the
     * one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GE</code> : Greater than or equal.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>GT</code> : Greater than.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type than
     * the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does not equal
     * <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     * <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not relevant to
     * the <code>NOT_NULL</code> comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types, including
     * lists and maps.
     * <br>
     * <note>
     * <br>
     * This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute "
     * <code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean <code>false</code>.
     * This is because the attribute "<code>a</code>" exists; its data type is not relevant to the <code>NULL</code>
     * comparison operator.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is of type String, then the operator checks
     * for a substring match. If the target attribute of the comparison is of type Binary, then the operator looks for a
     * subsequence of the target that matches the input. If the target attribute of the comparison is a set ("
     * <code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it finds an
     * exact match with any member of the set.
     * <br>
     * <br>
     * CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String, Number,
     * or Binary (not a set type). If the target attribute of the comparison is a String, then the operator checks for
     * the absence of a substring match. If the target attribute of the comparison is Binary, then the operator checks
     * for the absence of a subsequence of the target that matches the input. If the target attribute of the comparison
     * is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator evaluates to true if it
     * <i>does not</i> find an exact match with any member of the set.
     * <br>
     * <br>
     * NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     * " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BEGINS_WITH</code> : Checks for a prefix.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary (not a
     * Number or a set type). The target attribute of the comparison must be of type String or Binary (not a Number or a
     * set type).
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>IN</code> : Checks for matching elements in a list.
     * <br>
     * <br>
     * <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type String,
     * Number, or Binary. These attributes are compared against an existing attribute of an item. If any elements of the
     * input are equal to the item attribute, the expression evaluates to true.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second value.
     * <br>
     * <br>
     * <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type, either
     * String, Number, or Binary (not a set type). A target attribute matches if the target value is greater than, or
     * equal to, the first element and less than, or equal to, the second element. If an item contains an
     * <code>AttributeValue</code> element of a different type than the one provided in the request, the value does not
     * match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>. Also,
     * <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     * <br>
     * </li>
     * </ul>
     * 
     * @param comparisonOperator
     *        A comparator for evaluating attributes in the <code>AttributeValueList</code>. For example, equals,
     *        greater than, less than, etc.<br>
     *        <br>
     *        The following comparison operators are available:
     *        <br>
     *        <br>
     *        <code>EQ | NE | LE | LT | GE | GT | NOT_NULL | NULL | CONTAINS | NOT_CONTAINS | BEGINS_WITH | IN | BETWEEN</code>
     *        <br>
     *        <br>
     *        The following are descriptions of each comparison operator.
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>EQ</code> : Equal. <code>EQ</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code>
     *        element of a different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NE</code> : Not equal. <code>NE</code> is supported for all data types, including lists and maps.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        Binary, String Set, Number Set, or Binary Set. If an item contains an <code>AttributeValue</code> of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not equal
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LE</code> : Less than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>LT</code> : Less than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String, Number,
     *        or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a different type
     *        than the one provided in the request, the value does not match. For example, <code>{"S":"6"}</code> does
     *        not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not compare to
     *        <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GE</code> : Greater than or equal.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>GT</code> : Greater than.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If an item contains an <code>AttributeValue</code> element of a
     *        different type than the one provided in the request, the value does not match. For example,
     *        <code>{"S":"6"}</code> does not equal <code>{"N":"6"}</code>. Also, <code>{"N":"6"}</code> does not
     *        compare to <code>{"NS":["6", "2", "1"]}</code>.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_NULL</code> : The attribute exists. <code>NOT_NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the existence of an attribute, not its data type. If the data type of attribute "
     *        <code>a</code>" is null, and you evaluate it using <code>NOT_NULL</code>, the result is a Boolean
     *        <code>true</code>. This result is because the attribute "<code>a</code>" exists; its data type is not
     *        relevant to the <code>NOT_NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>NULL</code> : The attribute does not exist. <code>NULL</code> is supported for all data types,
     *        including lists and maps.
     *        <br>
     *        <note>
     *        <br>
     *        This operator tests for the nonexistence of an attribute, not its data type. If the data type of attribute
     *        "<code>a</code>" is null, and you evaluate it using <code>NULL</code>, the result is a Boolean
     *        <code>false</code>. This is because the attribute "<code>a</code>" exists; its data type is not relevant
     *        to the <code>NULL</code> comparison operator.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        <code>CONTAINS</code> : Checks for a subsequence, or value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is of type String, then the
     *        operator checks for a substring match. If the target attribute of the comparison is of type Binary, then
     *        the operator looks for a subsequence of the target that matches the input. If the target attribute of the
     *        comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"), then the operator
     *        evaluates to true if it finds an exact match with any member of the set.
     *        <br>
     *        <br>
     *        CONTAINS is supported for lists: When evaluating "<code>a CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>NOT_CONTAINS</code> : Checks for absence of a subsequence, or absence of a value in a set.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> element of type String,
     *        Number, or Binary (not a set type). If the target attribute of the comparison is a String, then the
     *        operator checks for the absence of a substring match. If the target attribute of the comparison is Binary,
     *        then the operator checks for the absence of a subsequence of the target that matches the input. If the
     *        target attribute of the comparison is a set ("<code>SS</code>", "<code>NS</code>", or "<code>BS</code>"),
     *        then the operator evaluates to true if it <i>does not</i> find an exact match with any member of the set.
     *        <br>
     *        <br>
     *        NOT_CONTAINS is supported for lists: When evaluating "<code>a NOT CONTAINS b</code>", "<code>a</code>
     *        " can be a list; however, "<code>b</code>" cannot be a set, a map, or a list.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BEGINS_WITH</code> : Checks for a prefix.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain only one <code>AttributeValue</code> of type String or Binary
     *        (not a Number or a set type). The target attribute of the comparison must be of type String or Binary (not
     *        a Number or a set type).
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>IN</code> : Checks for matching elements in a list.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> can contain one or more <code>AttributeValue</code> elements of type
     *        String, Number, or Binary. These attributes are compared against an existing attribute of an item. If any
     *        elements of the input are equal to the item attribute, the expression evaluates to true.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>BETWEEN</code> : Greater than or equal to the first value, and less than or equal to the second
     *        value.
     *        <br>
     *        <br>
     *        <code>AttributeValueList</code> must contain two <code>AttributeValue</code> elements of the same type,
     *        either String, Number, or Binary (not a set type). A target attribute matches if the target value is
     *        greater than, or equal to, the first element and less than, or equal to, the second element. If an item
     *        contains an <code>AttributeValue</code> element of a different type than the one provided in the request,
     *        the value does not match. For example, <code>{"S":"6"}</code> does not compare to <code>{"N":"6"}</code>.
     *        Also, <code>{"N":"6"}</code> does not compare to <code>{"NS":["6", "2", "1"]}</code>
     *        <br>
     *        </li>
     *        </ul>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see ComparisonOperator
     */

    public ExpectedAttributeValue withComparisonOperator(ComparisonOperator comparisonOperator) {
        setComparisonOperator(comparisonOperator);
        return this;
    }

    /**
     * <br>
     * One or more values to evaluate against the supplied attribute. The number of values in the list depends on the
     * <code>ComparisonOperator</code> being used.
     * <br>
     * <br>
     * For type Number, value comparisons are numeric.
     * <br>
     * <br>
     * String value comparisons for greater than, equals, or less than are based on ASCII character code values. For
     * example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than <code>B</code>. For a
     * list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia
     * .org/wiki/ASCII#ASCII_printable_characters</a>.
     * <br>
     * <br>
     * For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     * <br>
     * <br>
     * For information on specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data Format</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return One or more values to evaluate against the supplied attribute. The number of values in the list depends
     *         on the <code>ComparisonOperator</code> being used.<br>
     *         <br>
     *         For type Number, value comparisons are numeric.
     *         <br>
     *         <br>
     *         String value comparisons for greater than, equals, or less than are based on ASCII character code values.
     *         For example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than
     *         <code>B</code>. For a list of code values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters"
     *         >http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *         <br>
     *         <br>
     *         For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     *         <br>
     *         <br>
     *         For information on specifying data types in JSON, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data
     *         Format</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public java.util.List<AttributeValue> getAttributeValueList() {
        return attributeValueList;
    }

    /**
     * <br>
     * One or more values to evaluate against the supplied attribute. The number of values in the list depends on the
     * <code>ComparisonOperator</code> being used.
     * <br>
     * <br>
     * For type Number, value comparisons are numeric.
     * <br>
     * <br>
     * String value comparisons for greater than, equals, or less than are based on ASCII character code values. For
     * example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than <code>B</code>. For a
     * list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia
     * .org/wiki/ASCII#ASCII_printable_characters</a>.
     * <br>
     * <br>
     * For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     * <br>
     * <br>
     * For information on specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data Format</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param attributeValueList
     *        One or more values to evaluate against the supplied attribute. The number of values in the list depends on
     *        the <code>ComparisonOperator</code> being used.<br>
     *        <br>
     *        For type Number, value comparisons are numeric.
     *        <br>
     *        <br>
     *        String value comparisons for greater than, equals, or less than are based on ASCII character code values.
     *        For example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than
     *        <code>B</code>. For a list of code values, see <a
     *        href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters"
     *        >http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *        <br>
     *        <br>
     *        For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     *        <br>
     *        <br>
     *        For information on specifying data types in JSON, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data
     *        Format</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setAttributeValueList(java.util.Collection<AttributeValue> attributeValueList) {
        if (attributeValueList == null) {
            this.attributeValueList = null;
            return;
        }

        this.attributeValueList = new java.util.ArrayList<AttributeValue>(attributeValueList);
    }

    /**
     * <br>
     * One or more values to evaluate against the supplied attribute. The number of values in the list depends on the
     * <code>ComparisonOperator</code> being used.
     * <br>
     * <br>
     * For type Number, value comparisons are numeric.
     * <br>
     * <br>
     * String value comparisons for greater than, equals, or less than are based on ASCII character code values. For
     * example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than <code>B</code>. For a
     * list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia
     * .org/wiki/ASCII#ASCII_printable_characters</a>.
     * <br>
     * <br>
     * For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     * <br>
     * <br>
     * For information on specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data Format</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     * <br>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setAttributeValueList(java.util.Collection)} or {@link #withAttributeValueList(java.util.Collection)} if
     * you want to override the existing values.
     * <br>
     *
     * @param attributeValueList
     *        One or more values to evaluate against the supplied attribute. The number of values in the list depends on
     *        the <code>ComparisonOperator</code> being used.<br>
     *        <br>
     *        For type Number, value comparisons are numeric.
     *        <br>
     *        <br>
     *        String value comparisons for greater than, equals, or less than are based on ASCII character code values.
     *        For example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than
     *        <code>B</code>. For a list of code values, see <a
     *        href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters"
     *        >http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *        <br>
     *        <br>
     *        For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     *        <br>
     *        <br>
     *        For information on specifying data types in JSON, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data
     *        Format</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ExpectedAttributeValue withAttributeValueList(AttributeValue... attributeValueList) {
        if (this.attributeValueList == null) {
            setAttributeValueList(new java.util.ArrayList<AttributeValue>(attributeValueList.length));
        }
        for (AttributeValue ele : attributeValueList) {
            this.attributeValueList.add(ele);
        }
        return this;
    }

    /**
     * <br>
     * One or more values to evaluate against the supplied attribute. The number of values in the list depends on the
     * <code>ComparisonOperator</code> being used.
     * <br>
     * <br>
     * For type Number, value comparisons are numeric.
     * <br>
     * <br>
     * String value comparisons for greater than, equals, or less than are based on ASCII character code values. For
     * example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than <code>B</code>. For a
     * list of code values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia
     * .org/wiki/ASCII#ASCII_printable_characters</a>.
     * <br>
     * <br>
     * For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     * <br>
     * <br>
     * For information on specifying data types in JSON, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data Format</a> in
     * the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param attributeValueList
     *        One or more values to evaluate against the supplied attribute. The number of values in the list depends on
     *        the <code>ComparisonOperator</code> being used.<br>
     *        <br>
     *        For type Number, value comparisons are numeric.
     *        <br>
     *        <br>
     *        String value comparisons for greater than, equals, or less than are based on ASCII character code values.
     *        For example, <code>a</code> is greater than <code>A</code>, and <code>a</code> is greater than
     *        <code>B</code>. For a list of code values, see <a
     *        href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters"
     *        >http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *        <br>
     *        <br>
     *        For Binary, DynamoDB treats each byte of the binary data as unsigned when it compares binary values.
     *        <br>
     *        <br>
     *        For information on specifying data types in JSON, see <a
     *        href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataFormat.html">JSON Data
     *        Format</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ExpectedAttributeValue withAttributeValueList(java.util.Collection<AttributeValue> attributeValueList) {
        setAttributeValueList(attributeValueList);
        return this;
    }
}
