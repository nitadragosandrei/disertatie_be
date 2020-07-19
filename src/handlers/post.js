import AWS from "aws-sdk";

const config = {
  region: "eu-central-1",
};
const dynamoDb = new AWS.DynamoDB.DocumentClient(config);
// const middy = require("middy");
// const { cors } = require("middy/middlewares");

export const post = async (event, context, callback) => {
  const params = {
    TableName: "myTable",
    Item: JSON.parse(event.body),
  };
  try {
    await dynamoDb.put(params).promise();
    const response = {
      statusCode: 200,
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Credentials": true,
      },
      body: "",
    };
    return response;
  } catch (error) {
    console.log(error);
  }
};

// module.exports.put = put;
