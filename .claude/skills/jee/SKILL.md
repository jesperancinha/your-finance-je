---
name: Java Enterprise Edition Frameworks
description: Conventions for using in all JEE frameworks. These are common standards for CDI
---

## 1. Do not use open and correct annotation usage for use-site targets

1. Make sure that the kotlin plugin `no-arg` is being used in Maven or Gradle
2. Do not use `open` if the plugin `all-open` is being used in Maven or Gradle
3. Params annotated with `@Claim` should be injected with use-site target `param` as `@param:Claim`
