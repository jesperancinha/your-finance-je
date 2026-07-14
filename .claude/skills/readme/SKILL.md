---
name: Readme standards
description: Conventions to use in Readme files
---

## 1. Remove the usage of unresolved anchors

Unresolved anchors that don't translate to a link or a website should be removed.
The most important examples of this are the usage of `(#)`. This used to be a guarantee that the image would be displayed.
This is no longer necessary, and the svg icons get generated with or without the link.

Replace

```text
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/your-finance-je.svg)](#)
```

with 

```text
![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/your-finance-je.svg)
```
