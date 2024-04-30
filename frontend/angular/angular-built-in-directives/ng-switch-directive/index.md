# Using NgSwitch and NgSwitchCase in angular

When we have multiple else-if block or want to render some content based on many conditions we can use ngSwitch directive in angular template file instead of multiple elseIf block.

It assumes that, you have already angular application bootstrapped. Or you can refer this tutorial: [Create Your First Angular Application](https://javaondemand.com/create-your-first-angular-application/)


Then, open your **app.component.ts** file and create two variables. 

**app.component.ts** file:

```
export class AppComponent {

  day : number = 4;
  nameOfTheDay :string = "It is Tuesday";
}
```

**app.component.html** file:

```
<div [ngSwitch]="day">
<h1 *ngSwitchCase="1">{{nameOfTheDay}}</h1>
<h1 *ngSwitchCase="2">{{nameOfTheDay}}</h1>
<h1 *ngSwitchCase="3">{{nameOfTheDay}}</h1>
<h1 *ngSwitchCase="4">{{nameOfTheDay}}</h1> <!--only this block will render-->
<h1 *ngSwitchCase="5">{{nameOfTheDay}}</h1>
<h1 *ngSwitchCase="6">{{nameOfTheDay}}</h1>
<h1 *ngSwitchCase="7">{{nameOfTheDay}}</h1>
</div>
```

Output: 

![Alt text](image-1.png)

Additionally, we can also use ngSwitchDefault directive, if no condition or NgSwitchCase expression is matched then, it will be rendered.

Such as, 

```
in app.component.ts
//set your day variable out of 7
day: number = 8;

//update your app.component.html file

<div [ngSwitch]="day">
  <h1 *ngSwitchCase="1">It is Saturday</h1>
  <h1 *ngSwitchCase="2">It is Sunday</h1>
  <h1 *ngSwitchCase="3">It is Monday</h1>
  <h1 *ngSwitchCase="4">It is Tuesday</h1> <!--only this block will render-->
  <h1 *ngSwitchCase="5">It is Wednesday</h1>
  <h1 *ngSwitchCase="6">It is Thursday</h1>
  <h1 *ngSwitchCase="7">It is Friday</h1>
  <h1 *ngSwitchDefault>It is may be <span style="color: red;">red</span> friday.</h1>
  </div>
```


![alt text](image2.png)