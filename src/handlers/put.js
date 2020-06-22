import AWS from "aws-sdk";
const config = {
  region: "eu-central-1",
};
const dynamoDb = new AWS.DynamoDB.DocumentClient(config);

export const put = async (event, context, callback) => {
  const params = {
    TableName: "myTable",
    Item: {
      userID: "2",
      noteID: "2",
      Dragos: "are pula mearee",
    },
  };
  try {
    return dynamoDb.put(params).promise();
  } catch (error) {
    console.log(error);
  }
};

// module.exports.put = put;
