import AWS from "aws-sdk";
const config = {
  region: "eu-central-1",
};
const dynamoDb = new AWS.DynamoDB.DocumentClient(config);

export const post = async (event, context, callback) => {
  const params = {
    TableName: "myTable",
    Item: JSON.parse(event.body),
  };
  try {
    return dynamoDb.put(params).promise();
  } catch (error) {
    console.log(error);
  }
};

// module.exports.put = put;
