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
 * For the <code>UpdateItem</code> operation, represents the attributes to be modified, the action to perform on each,
 * and the new value for each.
 * <br>
 * <note>
 * <br>
 * You cannot use <code>UpdateItem</code> to update any primary key attributes. Instead, you will need to delete the
 * item, and then use <code>PutItem</code> to create a new item with new attributes.
 * <br>
 * </note>
 * <br>
 * Attribute values cannot be null; string and binary type attributes must have lengths greater than zero; and set type
 * attributes must not be empty. Requests with empty values will be rejected with a <code>ValidationException</code>
 * exception.
 * <br>
 *
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/AttributeValueUpdate" target="_top">AWS API
 *      Documentation</a>
 */
@EqualsAndHashCode @ToString
public class AttributeValueUpdate implements Serializable {

    /**
     * <br>
     * Represents the data for an attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     */
    @JsonProperty("Value")
    private AttributeValue value;
    /**
     * <br>
     * Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     * <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     * <br>
     * <br>
     * <b>If an item with the specified <i>Key</i> is found in the table:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is replaced by
     * the new value.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The data
     * type of the specified value must match the existing value's data type.
     * <br>
     * <br>
     * If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if the
     * attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified <code>[a,c]</code>,
     * then the final attribute value would be <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to the
     * item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the
     * attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then the <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses 0 as the initial value.
     * <br>
     * <br>
     * In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement an
     * attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For example, suppose
     * that the item you want to update does not yet have an attribute named <i>itemcount</i>, but you decide to
     * <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it currently does not exist.
     * DynamoDB will create the <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add
     * <code>3</code> to it. The result will be a new <i>itemcount</i> attribute in the item, with a value of
     * <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set, and if the <code>Value</code> is also a set, then the <code>Value</code> is
     * added to the existing set. (This is a <i>set</i> operation, not mathematical addition.) For example, if the
     * attribute value was the set <code>[1,2]</code>, and the <code>ADD</code> action specified <code>[3]</code>, then
     * the final attribute value would be <code>[1,2,3]</code>. An error occurs if an Add action is specified for a set
     * attribute and the attribute type specified does not match the existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings. The same holds true for number sets and binary sets.
     * <br>
     * </li>
     * </ul>
     * <br>
     * This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     * <code>ADD</code> for any other data types.
     * <br>
     * </li>
     * </ul>
     * <br>
     * <b>If no item with the specified <i>Key</i> is found:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the attribute.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers) for the
     * attribute value. The only data types allowed are number and number set; no other data types can be specified.
     * <br>
     * </li>
     * </ul>
     */
    @JsonProperty("Action")
    private String action;

    /**
     * Default constructor for AttributeValueUpdate object. Callers should use the setter or fluent setter (with...)
     * methods to initialize the object after creating it.
     */
    public AttributeValueUpdate() {
    }

    /**
     * Constructs a new AttributeValueUpdate object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param value
     *        Represents the data for an attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @param action
     *        Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     *        <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     *        <br>
     *        <br>
     *        <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *        replaced by the new value.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The
     *        data type of the specified value must match the existing value's data type.
     *        <br>
     *        <br>
     *        If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if
     *        the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *        <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *        an error.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to
     *        the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of
     *        the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *        <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *        number, then it is subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses 0 as the initial value.
     *        <br>
     *        <br>
     *        In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *        an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *        example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *        but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *        currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *        <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *        in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *        <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *        addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *        action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *        occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *        the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *        binary sets.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *        <code>ADD</code> for any other data types.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        <b>If no item with the specified <i>Key</i> is found:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *        attribute.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *        for the attribute value. The only data types allowed are number and number set; no other data types can be
     *        specified.
     *        <br>
     *        </li>
     */
    public AttributeValueUpdate(AttributeValue value, String action) {
        setValue(value);
        setAction(action);
    }

    /**
     * Constructs a new AttributeValueUpdate object. Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param value
     *        Represents the data for an attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @param action
     *        Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     *        <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     *        <br>
     *        <br>
     *        <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *        replaced by the new value.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The
     *        data type of the specified value must match the existing value's data type.
     *        <br>
     *        <br>
     *        If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if
     *        the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *        <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *        an error.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to
     *        the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of
     *        the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *        <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *        number, then it is subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses 0 as the initial value.
     *        <br>
     *        <br>
     *        In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *        an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *        example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *        but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *        currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *        <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *        in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *        <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *        addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *        action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *        occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *        the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *        binary sets.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *        <code>ADD</code> for any other data types.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        <b>If no item with the specified <i>Key</i> is found:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *        attribute.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *        for the attribute value. The only data types allowed are number and number set; no other data types can be
     *        specified.
     *        <br>
     *        </li>
     */
    public AttributeValueUpdate(AttributeValue value, AttributeAction action) {
        setValue(value);
        setAction(action.toString());
    }

    /**
     * <br>
     * Represents the data for an attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param value
     *        Represents the data for an attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public void setValue(AttributeValue value) {
        this.value = value;
    }

    /**
     * <br>
     * Represents the data for an attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @return Represents the data for an attribute.<br>
     *         <br>
     *         Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *         data itself.
     *         <br>
     *         <br>
     *         For more information, see <a href=
     *         "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *         >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */

    public AttributeValue getValue() {
        return this.value;
    }

    /**
     * <br>
     * Represents the data for an attribute.
     * <br>
     * <br>
     * Each attribute value is described as a name-value pair. The name is the data type, and the value is the data
     * itself.
     * <br>
     * <br>
     * For more information, see <a href=
     * "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     * >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <br>
     *
     * @param value
     *        Represents the data for an attribute.<br>
     *        <br>
     *        Each attribute value is described as a name-value pair. The name is the data type, and the value is the
     *        data itself.
     *        <br>
     *        <br>
     *        For more information, see <a href=
     *        "http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
     *        >Data TYpes</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public AttributeValueUpdate withValue(AttributeValue value) {
        setValue(value);
        return this;
    }

    /**
     * <br>
     * Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     * <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     * <br>
     * <br>
     * <b>If an item with the specified <i>Key</i> is found in the table:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is replaced by
     * the new value.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The data
     * type of the specified value must match the existing value's data type.
     * <br>
     * <br>
     * If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if the
     * attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified <code>[a,c]</code>,
     * then the final attribute value would be <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to the
     * item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the
     * attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then the <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses 0 as the initial value.
     * <br>
     * <br>
     * In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement an
     * attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For example, suppose
     * that the item you want to update does not yet have an attribute named <i>itemcount</i>, but you decide to
     * <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it currently does not exist.
     * DynamoDB will create the <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add
     * <code>3</code> to it. The result will be a new <i>itemcount</i> attribute in the item, with a value of
     * <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set, and if the <code>Value</code> is also a set, then the <code>Value</code> is
     * added to the existing set. (This is a <i>set</i> operation, not mathematical addition.) For example, if the
     * attribute value was the set <code>[1,2]</code>, and the <code>ADD</code> action specified <code>[3]</code>, then
     * the final attribute value would be <code>[1,2,3]</code>. An error occurs if an Add action is specified for a set
     * attribute and the attribute type specified does not match the existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings. The same holds true for number sets and binary sets.
     * <br>
     * </li>
     * </ul>
     * <br>
     * This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     * <code>ADD</code> for any other data types.
     * <br>
     * </li>
     * </ul>
     * <br>
     * <b>If no item with the specified <i>Key</i> is found:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the attribute.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers) for the
     * attribute value. The only data types allowed are number and number set; no other data types can be specified.
     * <br>
     * </li>
     * </ul>
     * 
     * @param action
     *        Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     *        <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the
     *        table.<br>
     *        <br>
     *        <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *        replaced by the new value.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The
     *        data type of the specified value must match the existing value's data type.
     *        <br>
     *        <br>
     *        If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if
     *        the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *        <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *        an error.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to
     *        the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of
     *        the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *        <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *        number, then it is subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses 0 as the initial value.
     *        <br>
     *        <br>
     *        In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *        an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *        example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *        but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *        currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *        <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *        in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *        <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *        addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *        action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *        occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *        the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *        binary sets.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *        <code>ADD</code> for any other data types.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        <b>If no item with the specified <i>Key</i> is found:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *        attribute.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *        for the attribute value. The only data types allowed are number and number set; no other data types can be
     *        specified.
     *        <br>
     *        </li>
     * @see AttributeAction
     */

    public void setAction(String action) {
        this.action = action;
    }

    /**
     * <br>
     * Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     * <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     * <br>
     * <br>
     * <b>If an item with the specified <i>Key</i> is found in the table:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is replaced by
     * the new value.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The data
     * type of the specified value must match the existing value's data type.
     * <br>
     * <br>
     * If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if the
     * attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified <code>[a,c]</code>,
     * then the final attribute value would be <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to the
     * item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the
     * attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then the <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses 0 as the initial value.
     * <br>
     * <br>
     * In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement an
     * attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For example, suppose
     * that the item you want to update does not yet have an attribute named <i>itemcount</i>, but you decide to
     * <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it currently does not exist.
     * DynamoDB will create the <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add
     * <code>3</code> to it. The result will be a new <i>itemcount</i> attribute in the item, with a value of
     * <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set, and if the <code>Value</code> is also a set, then the <code>Value</code> is
     * added to the existing set. (This is a <i>set</i> operation, not mathematical addition.) For example, if the
     * attribute value was the set <code>[1,2]</code>, and the <code>ADD</code> action specified <code>[3]</code>, then
     * the final attribute value would be <code>[1,2,3]</code>. An error occurs if an Add action is specified for a set
     * attribute and the attribute type specified does not match the existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings. The same holds true for number sets and binary sets.
     * <br>
     * </li>
     * </ul>
     * <br>
     * This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     * <code>ADD</code> for any other data types.
     * <br>
     * </li>
     * </ul>
     * <br>
     * <b>If no item with the specified <i>Key</i> is found:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the attribute.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers) for the
     * attribute value. The only data types allowed are number and number set; no other data types can be specified.
     * <br>
     * </li>
     * </ul>
     * 
     * @return Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>,
     *         and <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the
     *         table.<br>
     *         <br>
     *         <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *         replaced by the new value.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item.
     *         The data type of the specified value must match the existing value's data type.
     *         <br>
     *         <br>
     *         If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example,
     *         if the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *         <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *         an error.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added
     *         to the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type
     *         of the attribute:
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *         <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *         number, then it is subtracted from the existing attribute.
     *         <br>
     *         <note>
     *         <br>
     *         If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist
     *         before the update, DynamoDB uses 0 as the initial value.
     *         <br>
     *         <br>
     *         In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *         an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *         example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *         but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *         currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *         <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *         in the item, with a value of <code>3</code>.
     *         <br>
     *         </note></li>
     *         <li>
     *         <br>
     *         If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *         <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *         addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *         action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *         occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *         the existing set type.
     *         <br>
     *         <br>
     *         Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *         strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *         binary sets.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *         <code>ADD</code> for any other data types.
     *         <br>
     *         </li>
     *         </ul>
     *         <br>
     *         <b>If no item with the specified <i>Key</i> is found:</b>
     *         <br>
     *         <ul>
     *         <li>
     *         <br>
     *         <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *         attribute.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *         <br>
     *         </li>
     *         <li>
     *         <br>
     *         <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *         for the attribute value. The only data types allowed are number and number set; no other data types can
     *         be specified.
     *         <br>
     *         </li>
     * @see AttributeAction
     */

    public String getAction() {
        return this.action;
    }

    /**
     * <br>
     * Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     * <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     * <br>
     * <br>
     * <b>If an item with the specified <i>Key</i> is found in the table:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is replaced by
     * the new value.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The data
     * type of the specified value must match the existing value's data type.
     * <br>
     * <br>
     * If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if the
     * attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified <code>[a,c]</code>,
     * then the final attribute value would be <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to the
     * item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the
     * attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then the <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses 0 as the initial value.
     * <br>
     * <br>
     * In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement an
     * attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For example, suppose
     * that the item you want to update does not yet have an attribute named <i>itemcount</i>, but you decide to
     * <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it currently does not exist.
     * DynamoDB will create the <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add
     * <code>3</code> to it. The result will be a new <i>itemcount</i> attribute in the item, with a value of
     * <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set, and if the <code>Value</code> is also a set, then the <code>Value</code> is
     * added to the existing set. (This is a <i>set</i> operation, not mathematical addition.) For example, if the
     * attribute value was the set <code>[1,2]</code>, and the <code>ADD</code> action specified <code>[3]</code>, then
     * the final attribute value would be <code>[1,2,3]</code>. An error occurs if an Add action is specified for a set
     * attribute and the attribute type specified does not match the existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings. The same holds true for number sets and binary sets.
     * <br>
     * </li>
     * </ul>
     * <br>
     * This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     * <code>ADD</code> for any other data types.
     * <br>
     * </li>
     * </ul>
     * <br>
     * <b>If no item with the specified <i>Key</i> is found:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the attribute.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers) for the
     * attribute value. The only data types allowed are number and number set; no other data types can be specified.
     * <br>
     * </li>
     * </ul>
     * 
     * @param action
     *        Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     *        <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the
     *        table.<br>
     *        <br>
     *        <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *        replaced by the new value.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The
     *        data type of the specified value must match the existing value's data type.
     *        <br>
     *        <br>
     *        If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if
     *        the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *        <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *        an error.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to
     *        the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of
     *        the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *        <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *        number, then it is subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses 0 as the initial value.
     *        <br>
     *        <br>
     *        In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *        an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *        example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *        but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *        currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *        <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *        in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *        <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *        addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *        action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *        occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *        the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *        binary sets.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *        <code>ADD</code> for any other data types.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        <b>If no item with the specified <i>Key</i> is found:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *        attribute.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *        for the attribute value. The only data types allowed are number and number set; no other data types can be
     *        specified.
     *        <br>
     *        </li>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see AttributeAction
     */

    public AttributeValueUpdate withAction(String action) {
        setAction(action);
        return this;
    }

    /**
     * <br>
     * Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     * <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     * <br>
     * <br>
     * <b>If an item with the specified <i>Key</i> is found in the table:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is replaced by
     * the new value.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The data
     * type of the specified value must match the existing value's data type.
     * <br>
     * <br>
     * If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if the
     * attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified <code>[a,c]</code>,
     * then the final attribute value would be <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to the
     * item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the
     * attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then the <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses 0 as the initial value.
     * <br>
     * <br>
     * In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement an
     * attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For example, suppose
     * that the item you want to update does not yet have an attribute named <i>itemcount</i>, but you decide to
     * <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it currently does not exist.
     * DynamoDB will create the <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add
     * <code>3</code> to it. The result will be a new <i>itemcount</i> attribute in the item, with a value of
     * <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set, and if the <code>Value</code> is also a set, then the <code>Value</code> is
     * added to the existing set. (This is a <i>set</i> operation, not mathematical addition.) For example, if the
     * attribute value was the set <code>[1,2]</code>, and the <code>ADD</code> action specified <code>[3]</code>, then
     * the final attribute value would be <code>[1,2,3]</code>. An error occurs if an Add action is specified for a set
     * attribute and the attribute type specified does not match the existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings. The same holds true for number sets and binary sets.
     * <br>
     * </li>
     * </ul>
     * <br>
     * This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     * <code>ADD</code> for any other data types.
     * <br>
     * </li>
     * </ul>
     * <br>
     * <b>If no item with the specified <i>Key</i> is found:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the attribute.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers) for the
     * attribute value. The only data types allowed are number and number set; no other data types can be specified.
     * <br>
     * </li>
     * </ul>
     * 
     * @param action
     *        Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     *        <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the
     *        table.<br>
     *        <br>
     *        <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *        replaced by the new value.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The
     *        data type of the specified value must match the existing value's data type.
     *        <br>
     *        <br>
     *        If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if
     *        the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *        <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *        an error.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to
     *        the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of
     *        the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *        <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *        number, then it is subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses 0 as the initial value.
     *        <br>
     *        <br>
     *        In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *        an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *        example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *        but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *        currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *        <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *        in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *        <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *        addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *        action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *        occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *        the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *        binary sets.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *        <code>ADD</code> for any other data types.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        <b>If no item with the specified <i>Key</i> is found:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *        attribute.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *        for the attribute value. The only data types allowed are number and number set; no other data types can be
     *        specified.
     *        <br>
     *        </li>
     * @see AttributeAction
     */

    public void setAction(AttributeAction action) {
        this.action = action.toString();
    }

    /**
     * <br>
     * Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     * <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the table.
     * <br>
     * <br>
     * <b>If an item with the specified <i>Key</i> is found in the table:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is replaced by
     * the new value.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The data
     * type of the specified value must match the existing value's data type.
     * <br>
     * <br>
     * If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if the
     * attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified <code>[a,c]</code>,
     * then the final attribute value would be <code>[b]</code>. Specifying an empty set is an error.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to the
     * item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of the
     * attribute:
     * <br>
     * <ul>
     * <li>
     * <br>
     * If the existing attribute is a number, and if <code>Value</code> is also a number, then the <code>Value</code> is
     * mathematically added to the existing attribute. If <code>Value</code> is a negative number, then it is subtracted
     * from the existing attribute.
     * <br>
     * <note>
     * <br>
     * If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before the
     * update, DynamoDB uses 0 as the initial value.
     * <br>
     * <br>
     * In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement an
     * attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For example, suppose
     * that the item you want to update does not yet have an attribute named <i>itemcount</i>, but you decide to
     * <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it currently does not exist.
     * DynamoDB will create the <i>itemcount</i> attribute, set its initial value to <code>0</code>, and finally add
     * <code>3</code> to it. The result will be a new <i>itemcount</i> attribute in the item, with a value of
     * <code>3</code>.
     * <br>
     * </note></li>
     * <li>
     * <br>
     * If the existing data type is a set, and if the <code>Value</code> is also a set, then the <code>Value</code> is
     * added to the existing set. (This is a <i>set</i> operation, not mathematical addition.) For example, if the
     * attribute value was the set <code>[1,2]</code>, and the <code>ADD</code> action specified <code>[3]</code>, then
     * the final attribute value would be <code>[1,2,3]</code>. An error occurs if an Add action is specified for a set
     * attribute and the attribute type specified does not match the existing set type.
     * <br>
     * <br>
     * Both sets must have the same primitive data type. For example, if the existing data type is a set of strings, the
     * <code>Value</code> must also be a set of strings. The same holds true for number sets and binary sets.
     * <br>
     * </li>
     * </ul>
     * <br>
     * This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     * <code>ADD</code> for any other data types.
     * <br>
     * </li>
     * </ul>
     * <br>
     * <b>If no item with the specified <i>Key</i> is found:</b>
     * <br>
     * <ul>
     * <li>
     * <br>
     * <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the attribute.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     * <br>
     * </li>
     * <li>
     * <br>
     * <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers) for the
     * attribute value. The only data types allowed are number and number set; no other data types can be specified.
     * <br>
     * </li>
     * </ul>
     * 
     * @param action
     *        Specifies how to perform the update. Valid values are <code>PUT</code> (default), <code>DELETE</code>, and
     *        <code>ADD</code>. The behavior depends on whether the specified primary key already exists in the
     *        table.<br>
     *        <br>
     *        <b>If an item with the specified <i>Key</i> is found in the table:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - Adds the specified attribute to the item. If the attribute already exists, it is
     *        replaced by the new value.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - If no value is specified, the attribute and its value are removed from the item. The
     *        data type of the specified value must match the existing value's data type.
     *        <br>
     *        <br>
     *        If a <i>set</i> of values is specified, then those values are subtracted from the old set. For example, if
     *        the attribute value was the set <code>[a,b,c]</code> and the <code>DELETE</code> action specified
     *        <code>[a,c]</code>, then the final attribute value would be <code>[b]</code>. Specifying an empty set is
     *        an error.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - If the attribute does not already exist, then the attribute and its values are added to
     *        the item. If the attribute does exist, then the behavior of <code>ADD</code> depends on the data type of
     *        the attribute:
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        If the existing attribute is a number, and if <code>Value</code> is also a number, then the
     *        <code>Value</code> is mathematically added to the existing attribute. If <code>Value</code> is a negative
     *        number, then it is subtracted from the existing attribute.
     *        <br>
     *        <note>
     *        <br>
     *        If you use <code>ADD</code> to increment or decrement a number value for an item that doesn't exist before
     *        the update, DynamoDB uses 0 as the initial value.
     *        <br>
     *        <br>
     *        In addition, if you use <code>ADD</code> to update an existing item, and intend to increment or decrement
     *        an attribute value which does not yet exist, DynamoDB uses <code>0</code> as the initial value. For
     *        example, suppose that the item you want to update does not yet have an attribute named <i>itemcount</i>,
     *        but you decide to <code>ADD</code> the number <code>3</code> to this attribute anyway, even though it
     *        currently does not exist. DynamoDB will create the <i>itemcount</i> attribute, set its initial value to
     *        <code>0</code>, and finally add <code>3</code> to it. The result will be a new <i>itemcount</i> attribute
     *        in the item, with a value of <code>3</code>.
     *        <br>
     *        </note></li>
     *        <li>
     *        <br>
     *        If the existing data type is a set, and if the <code>Value</code> is also a set, then the
     *        <code>Value</code> is added to the existing set. (This is a <i>set</i> operation, not mathematical
     *        addition.) For example, if the attribute value was the set <code>[1,2]</code>, and the <code>ADD</code>
     *        action specified <code>[3]</code>, then the final attribute value would be <code>[1,2,3]</code>. An error
     *        occurs if an Add action is specified for a set attribute and the attribute type specified does not match
     *        the existing set type.
     *        <br>
     *        <br>
     *        Both sets must have the same primitive data type. For example, if the existing data type is a set of
     *        strings, the <code>Value</code> must also be a set of strings. The same holds true for number sets and
     *        binary sets.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        This action is only valid for an existing attribute whose data type is number or is a set. Do not use
     *        <code>ADD</code> for any other data types.
     *        <br>
     *        </li>
     *        </ul>
     *        <br>
     *        <b>If no item with the specified <i>Key</i> is found:</b>
     *        <br>
     *        <ul>
     *        <li>
     *        <br>
     *        <code>PUT</code> - DynamoDB creates a new item with the specified primary key, and then adds the
     *        attribute.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>DELETE</code> - Nothing happens; there is no attribute to delete.
     *        <br>
     *        </li>
     *        <li>
     *        <br>
     *        <code>ADD</code> - DynamoDB creates an item with the supplied primary key and number (or set of numbers)
     *        for the attribute value. The only data types allowed are number and number set; no other data types can be
     *        specified.
     *        <br>
     *        </li>
     * @return Returns a reference to this object so that method calls can be chained together.
     * @see AttributeAction
     */

    public AttributeValueUpdate withAction(AttributeAction action) {
        setAction(action);
        return this;
    }

}
