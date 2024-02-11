# Sharing Data between angular components

Using @Input and @Output decorator we can share data between components in angular.

@Input decorator: The flow of sharing data is parent to child

@Output decorator: The flow of sharing data is child to parent - but release an EventEmitter.


## Sharing Data Parent Component to Child Component using @Input decorator

1. Open your angular application directory or folder in your system terminal (Command Prompt) and create two angular component using the following command.

```js
$ ng generate component parent --inline-template --skip-tests
$ generate component child --inline-template --skip-tests
```

2. Now, open your angular application in VS code or in your favorite ide.

![Alt text](image-1.png)

You can see, there are two component files has been generated in parent and child folder. Our goal is to sharing data from parent to child using @Input decorator.

3. Now, open child.component.ts file and inside the component class declare a variable but don't initialize it as the value will come from the parent component.

child.component.ts

```
import { Component, Input } from '@angular/core';

@Component({
  selector: 'child-component',
  standalone: true,
  imports: [],
  template: `
    <div>
      <h1>Hello {{childMessage}} </h1>
    </div>
  `,
  styleUrl: './child.component.css'
})
export class ChildComponent {

  @Input() childMessage = ' '; //or @Input() childMessage! :
   
}
```

Here, first of all, we have import the Input decorator from @angular/core library package and you can see it at the top of the file. The, inside the typescript class, we have declared an empty string variable with @Input() decorator but didn't initialize it as the value will come from the parent component.

Note: @Input() decorator means here, the data or value will come from the parent component.

4. Now open the parent.component.ts file and declare a variable with data.

parent.component.ts 

```
import { Component } from '@angular/core';
import { ChildComponent } from '../child/child.component';

@Component({
  selector: 'parent-component',
  standalone: true,
  imports: [ChildComponent],
  template: `
    <child-component [childMessage]="parentMessage"></child-component>
  `,
  styleUrl: './parent.component.css'
})
export class ParentComponent {

  parentMessage : string = "Child Component"; 
}
```
Here, we import the ChildComponent typescript class at the top of the file first of all and add it in the imports array of @Component decorator making it as a known component for this parent.component.ts file. And then, use the child.component.ts file's selector here to display the child component template messages.

We have used the property binding syntax for sharing data from parent to child.

```
<child-component [childMessage]="parentMessage"]></child-component>
```

In left **```[childMessage]```:** is the child component empty property
**```parentMessage```:** is the parent component property with value. Later it's value will be added in the childMessage property.

5. In this final step, we have added the parent component selector in the app.component.html template file (which is the root component in our application.)

**parent.component.ts** file selector: **parent-component**

Open, app.component.html file and write the following:

```
<div>
<parent-component></parent-component>
</div>
//probably you get an error as the parent.component.ts file class isn't added in the app.component.ts file
```

**app.component.ts** file will look like now:

```
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ParentComponent } from './parent/parent.component'; // import the ParentComponent

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ParentComponent], //then, add it in the imports array
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {

  title: string = "Hello Angular";
}

```

6. Open your terminal and redirect the my-app directory and run the ng serve command.

```
$ ng serve --open
```

If you now open localhost:4200 in your web browser you see:

![Alt text](image-2.png)


Note: The most important thing is to note here, when you use one component in another component then, you must register that component typescript class in the imports array otherwise it is not possible to interact with that component logic. 

Like: if you have two components called A and B. And you want to use component A in component B. For achieving this, you have to first of all, the import the component A in the component B (yes, in imports [] array)


## Sharing Data from Child to Parent Component using @Output Decorator.

We will here use @Output decorator to share data from Parent to Child using @Output decorator. But, remember that, @Output decorator releases an EventEmitter.

Note: There is no no need to change anything in your component files.

1. Open child.component.ts file and include another property with @Output decorator.

**child.component.ts** file:

```
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'child-component',
  standalone: true,
  imports: [],
  template: `
    <div>
      <button type="button" (click)="sendData()">Button</button> <!--When you click the button, it sends data to the parent component-->
    </div>
  `,
  styleUrl: './child.component.css'
})
export class ChildComponent {

  @Input() childMessage : string = '';

  //output decorator
  @Output() childData = new EventEmitter<string>();

  //emit a string message
  sendData(){
    this.childData.emit("You have clicked the button");
    console.log("You have clicked the button");
  }
}
```

Note: You have to import he EventEmitter from @angular/core library.

Here, we have created a method that emits the childData property.

2. Now, open parent.component.ts file. 

**parent.component.ts** file:

```
import { Component } from '@angular/core';
import { ChildComponent } from '../child/child.component';

@Component({
  selector: 'parent-component',
  standalone: true,
  imports: [ChildComponent],
  template: `
  <div>
    <child-component (childData)="getData($event)"></child-component>
    <br/>
    <h1>Have You clicked the button?</h1>
    <h1>{{message}}</h1>
</div>
  `,

  styleUrl: './parent.component.css'
})
export class ParentComponent {

  message! : string;

  //method that accepts an event 
  getData(data : string){
    this.message = data;
  }
}

```

Here, when you clicked the button, the empty string message property will get value from the child component.

3. Please, run your development server from the terminal:

If you now invoke the url: http://localhost:4200/ you get a window like this before clicking the button:

![Alt text](image-3.png)

But when you click the button the window should be like this:

![Alt text](image-4.png)


Hope, you can now understand how we can share data between component using @Input and @Output decorator.
