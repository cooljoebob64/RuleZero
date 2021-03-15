import React, { useContext } from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { AuthContext } from './AuthProvider';

const RuleZeroStack = createStackNavigator();
const ModalStack = createStackNavigator();


function RuleZero() {
  const { logout } = useContext(AuthContext);

  return (
    <RuleZeroStack.Navigator>
    
    </RuleZeroStack.Navigator>
  );
}

export default function HomeStack() {
  return (
    <ModalStack.Navigator mode='modal' headerMode='none'>

    </ModalStack.Navigator>
  );
}