import React, {Component} from 'react';
import { View } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import { Text } from 'react-native-elements';
import { CheckBox } from 'react-native-elements'
import { Input } from 'react-native-elements';
import { Button } from 'react-native-elements';

export default class Build extends Component{
    state = { 
            red: false,
            black: false,
            blue: false,
            white: false,
            green: false,
            uncolored: false,
        }
    
        
    render() {
        return(
            <View>
            <Text h1>DECK BUILDER</Text>
             <Input
                placeholder="Deck Title"
                onChangeText={value => this.setState({ comment: value })}
            />
            <Input
                placeholder="Description of Deck"
                onChangeText={value => this.setState({ comment: value })}
            />
            <CheckBox
                center
                title='Red'
                checkedIcon='dot-circle-o'
                uncheckedIcon='circle-o'
                checked={this.state.checked}
                onPress={() => this.setState({checked: !this.state.checked})}
            />
            <CheckBox
                center
                title='Black'
                checkedIcon='dot-circle-o'
                uncheckedIcon='circle-o'
                checked={this.state.checked}
                onPress={() => this.setState({checked: !this.state.checked})}
            />
            <CheckBox
                center
                title='Blue'
                checkedIcon='dot-circle-o'
                uncheckedIcon='circle-o'
                checked={this.state.checked}
                onPress={() => this.setState({checked: !this.state.checked})}
            />
            <CheckBox
                center
                title='White'
                checkedIcon='dot-circle-o'
                uncheckedIcon='circle-o'
                checked={this.state.checked}
                onPress={() => this.setState({checked: !this.state.checked})}
            />
            <CheckBox
                center
                title='UnColored'
                checkedIcon='dot-circle-o'
                uncheckedIcon='circle-o'
                checked={this.state.checked}
                onPress={() => this.setState({checked: !this.state.checked})}
            />
            
            <Input
                placeholder="Number of Cards"
                onChangeText={value => this.setState({ comment: value })}
            />
            <Input
                placeholder="Qualities"
                onChangeText={value => this.setState({ comment: value })}
            />
            <Button
                title="SUBMIT"
                type="outline"
            />
            
            















            </View>
        )
    }
}