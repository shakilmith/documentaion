# Creating Interface 

Interface can be used as a data type and it is helpful for creating custom and reusable data type with properties for our components.

The following command will generate interface for you.

```
$ ng generate interface product 
```

//here the product is the name of our interface.

If you have angular application in your system, navigate the angular app in the terminal, in my case the angular app is: my-app. And then, run the above command to generate an interface for you. It's a .ts file only following the name of your interface.

```
$ ng generate interface product
```

If you open your application into your ide, you will see, in the app folder there is an interface named product.ts file.

Open product.ts file and you will see and exported interface product has already been bootstrapped for you.

```
export interface Product {
}
```
But, if you want to create interface manually, just create a .ts file with following code:

```
export interface <interface-name> {
}
```

Now, it is possible to add properties with appropriate data types. Like, our Product interface may contain, product id, name, price, image, description, quantity, shipping-info, stock-info etc. 

```
export interface Product {
    id: number,
    name: string,
    price: number,
    photo: string,
    description: string,
    isAvailable: boolean,
    weight: number
}
```