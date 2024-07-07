# Qute Built in Sections

Qute is a templating engine designed specifically to meet the Quarkus needs. The usage of reflection is minimized to reduce the size of native images. The API combines both the imperative and the non-blocking reactive style of coding. In the development mode, all files located in the src/main/resources/templates folder are watched for changes and modifications are immediately visible in your application. Furthermore, Qute attempts to detect most of the template problems at build time and fail fast.

Here we are going to describe little bit about qute built in sections. A section has a start tag that starts with #, followed by the name of the section such as {#if} and {#each} and corresponding end tag like {/each} or {/for}. The end tag can also be written like {/} instead of {/each}. Note, end tag is strictly required but optional for let and include section.

The build in Qute sections are:

<table style="width: 75%;">
        <tr style="text-align: left;">
            <th style="border-bottom: 1px solid #D6EEEE">Built-in section</th>
            <th style="border-bottom: 1px solid #D6EEEE">Supports Optional <br/> End Tag</th>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE">{#for}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">no</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#if}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">no</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#when}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">no</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#let}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">yes</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#with}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">no</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#include}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">yes</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#fragment}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">no</td>
        </tr>
        <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">{#cached}</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">no</td>
        </tr>
          <tr>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE"">User-defined Tags</td>
            <td style="padding: 8px; text-align: left; border-bottom: 1px solid #D6EEEE">no</td>
        </tr>
    </table>


You can simply check out how each section works using the respective link. 

**Note:** A section may contain several content blocks. The "main" block is always present. Additional/nested blocks also start with # and can have parameters too - {#else if item.isActive}. A section helper that defines the logic of a section can "execute" any of the blocks and evaluate the parameters.

Yes, you can also check out the qute reference documentation site: [https://quarkus.io/guides/qute-reference#sections](https://quarkus.io/guides/qute-reference#sections)

