---
name: Java Enterprise Edition Frameworks
description: Conventions for using in all JEE frameworks. These are common standards for CDI
---

## 1. Don't inject using properties. Inject using the constructor and params

1. For injection, make to only use the constructor
2. Use `@Inject` in the contructor directly. This will apply it to all injected fields
3. Make sure that the kotlin plugin `no-arg` is being used in Maven or Gradle
4. Do not use `open` if the plugin `all-open` is being used in Maven or Gradle
5. Params annotated with `@Claim` should be injected with use-site target `param` as `@param:Claim`
6. No contructor param should be annotated with `@Inject`

### Example 1


Replace this

```kotlin
open class AccountResource {

    @Inject
    @AccountsProduct
    open var accounts: Accounts? = null

    @Inject
    open var principal: Principal? = null

    @Inject
    open var jsonWebToken: JsonWebToken? = null

    @Inject
    @Claim("access")
    open var access: JsonString? = null

    @Claim("iat")
    @Inject
    open var iat: JsonNumber? = null

    @Inject
    @Claim("name")
    open var name: JsonString? = null

    @Inject
    @Claim("user_id")
    open var userId: JsonNumber? = null
}
```

with

```kotlin
class AccountResource @Inject constructor(
    @param:AccountsProduct
    var accounts: Accounts?,

    var principal: Principal? = null,

    var jsonWebToken: JsonWebToken? = null,

    @param:Claim("access")
    var access: JsonString? = null,

    @param:Claim("iat")
    var iat: JsonNumber? = null,

    @param:Claim("name")
    var name: JsonString? = null,

    @param: Claim("user_id")
    var userId: JsonNumber? = null
)
```