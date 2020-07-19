import AWS from "aws-sdk";
const config = {
  region: "eu-central-1",
};
const dynamoDb = new AWS.DynamoDB.DocumentClient(config);

export const get = async (event, context, callback) => {
  const params = {
    TableName: "myTable",
  };
  try {
    const response = await dynamoDb.scan(params).promise();
    console.log(response);
    return {
      statusCode: 200,
      body: JSON.stringify({
        Items: response.Items,
      }),
    };
  } catch (error) {
    console.log(error);
  }
};

// module.exports.put = put;
