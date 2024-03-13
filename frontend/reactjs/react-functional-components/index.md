# React Functional Components

Components are building block reusable codes of react application. They helps to render html content to the dom.

We can create two way components in react. Functional approach and ES6 class based approach. Compare the following scenario.


```
//creating a functional
function FunctionalComponent(){
  return <h1>I am functional component.</h1>
}

//creating an ES6 class component
class ClassComponent extends React.Component{
  render(){
    return <h1>I am a class component.</h1>
  }
}
```

Both components do the same thing. But it is recommended to use functional component in your newly created react applications. Yes, the functional approach looks very pretty.

## Root level component

Building react application means, we create a lot of components to achieve a certain goal. But, every react component (.js or .ts extension) file, must contain a root level or parent component and may contain more than one child components. And that component must be exported. Look at the below example.


```
import React from 'react';

function ParentComponent() {
  return (
    <div>

      <FirstChild />
      <SecondChild />
      <ThirdChild />

    </div>
  );
}

function FirstChild(){
  return <h1>First Child Component</h1>
}

function SecondChild(){
  return <h1>Second Child Component</h1>
}

function ThirdChild(){
  return <h1> Third Child Component</h1>
}

export default ParentComponent;
```

Here in the above code, you can see, we have a parent component and three child components. And we then invoke the child components in the parent (top level) component. At the end, we have exported the parent component ```export default ParentComponent;```

# Export a default top level component at the time of creation of the component

We can export a top level or parent component at the time of declaring the component.

```
//create and export a component
export default App(){ //it is root component of this file
  return <h1>Export a default Component</h1>
}
```

Note: A .js or .ts file (javascript module) must not contain more than one default or root level component. Thus, we can only use one export default syntax.


