import axios from "axios";
import { StatusBar } from "expo-status-bar";
import { Alert, Text, TextInput, TouchableOpacity } from "react-native";
import { View } from "react-native";

export default function App() {
  const doSignUp = async () => {
    let res = null;

    try {
      res = await axios.post("http://m.hellomh.site/users/join", {
        email: "aaa@naver.com",
        name: "홍길동",
        password: "abcd1234",
      });
      console.log(JSON.stringify(res));
    } catch (err) {
      console.error(err);
      Alert.alert("Sign Up", "회원가입에 실패하였습니다. " + err.response.data)
      return;
    }

    if(res.status == 200) {
        Alert.alert("Sign Up", "회원가입이 완료되었습니다")
        return;
    }
  };

  return (
    <View className="flex-1 justify-center items-center bg-white">
      <StatusBar style="auto" />
      <Text className="text-center mt-3 text-2xl font-light text-orange-300">
        Login
      </Text>
      {/* Additional components goes here */}
      <View className="mt-5 mx-5">
        <View>
          <Text className="text-gray-400">EMAIL:</Text>
          <TextInput
            placeholder="Enter Email..."
            className="border border-dotted p-2 text-gray-500 border-amber-400 mt-1"
          />
        </View>
        <View className="mt-3">
          <Text className="text-gray-400">PASSWORD:</Text>
          <TextInput
            secureTextEntry
            placeholder="Enter Password..."
            className="border text-gray-500 border-dotted p-2 border-amber-400 mt-1"
          />
        </View>
        <TouchableOpacity className="bg-orange-300 p-3 mt-4" onPress={doSignUp}>
          <Text className="text-center text-base p-2 mt-5 text-amber-800  bg-orange-400">
            Login
          </Text>
        </TouchableOpacity>

        <Text className="text-center font-normal text-gray-500 text-base mt-3">
          OR
        </Text>
        <View className="mt-4">
          <TouchableOpacity className="flex flex-row items-center justify-center p-2 bg-orange-300">
            <Text className="text-amber-500 mx-2 text-sm p-2">
              Sign In With Google
            </Text>
          </TouchableOpacity>
        </View>
        <View className="mt-6 flex-row justify-center">
          <Text className="">New to FreeCodeCamp? </Text>
          <TouchableOpacity>
            <Text className="text-amber-500">Create an Account</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}