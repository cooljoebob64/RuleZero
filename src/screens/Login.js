import React, { useState } from 'react';
import { 
    StyleSheet,
    StatusBar,
    Text,
    View,
    Image,
    TextInput,
    Button,
    TouchableOpacity,
} from 'react-native';

export default function Login(){
        const [email, setEmail] = useState("");
        const [password, setPassword] = useState("");

        return(
            <View style={styles.container}>
                <Image style={styles.image} source={require("../Assets/logo.png")} />
                <StatusBar style="auto" />
                <View style={styles.inputView}>
                
               <TextInput style={styles.TextInput}
                    placeholder="Email."
                    placeholderTextColor="#003f5c"
                    onChangeText={(email) => setEmail(email)} />
                </View>

                <View style={styles.inputView}>
        <TextInput
          style={styles.TextInput}
          placeholder="Password."
          placeholderTextColor="#003f5c"
          secureTextEntry={true}
          onChangeText={(password) => setPassword(password)}
        />
      </View> 
      <TouchableOpacity>
        <Text style={styles.forgot_button}>New User?</Text>
      </TouchableOpacity>
 
      <Button 
        title="LOGIN"
        style={styles.loginBtn} 
        onPress={() => {
          async () => {
            var myHeaders = new Headers();
              myHeaders.append("Content-Type", "application/x-www-form-urlencoded");
              myHeaders.append("Cookie", "JSESSIONID=0849CC59C6D4CF1F7D175E2F01DAA129");

              var urlencoded = new URLSearchParams();
              urlencoded.append("username", email);
              urlencoded.append("password", password);

              var requestOptions = {
                method: 'POST',
                headers: myHeaders,
                body: urlencoded,
                redirect: 'follow'
              };

              fetch("http://localhost:8080/login", requestOptions)
                .then(response => response.text())
                .then(result => console.log(result))
                .catch(error => console.log('error', error));
            }
          }
        }>
      </Button>
    </View>
  );
        }
 
 const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "white",
    alignItems: "center",
    justifyContent: "center",
  },
 
  image: {
    flex: 1,
    aspectRatio: .8,
    resizeMode: 'contain',
  },
 
  inputView: {
    backgroundColor: "gray",
    borderRadius: 30,
    width: "70%",
    height: 45,
    marginBottom: 20,
 
    alignItems: "center",
  },
 
  TextInput: {
    height: 50,
    flex: 1,
    padding: 10,
    marginLeft: 20,
  },
 
  forgot_button: {
    height: 30,
    marginBottom: 30,
  },
 
  loginBtn: {
    width: "80%",
    borderRadius: 25,
    height: 50,
    alignItems: "center",
    justifyContent: "center",
    marginTop: 40,
    backgroundColor: "gray",
    marginBottom: 20,
  },
});