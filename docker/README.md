# epicsmng docker images

This image has been developed to be used as base images for other projects.

This image can be based on the following OS: almalinux (9 or 10) or ubuntu (20.04, 22.04 or 24.04).

It provides the `epicsmng` executable; it uses the `root` user and no workspace directory is set.

## How to build images

This image has to be built with the main repository folder as context:

```bash
docker build -t epicsmng -f docker/Dockerfile.almalinux .
```

or

```bash
docker build -t epicsmng -f docker/Dockerfile.ubuntu .
```