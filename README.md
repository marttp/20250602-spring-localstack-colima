Use Colima context

```bash
docker context use colima
```

For forward Colima and Docker

```bash
export DOCKER_HOST="unix://$HOME/.colima/default/docker.sock"
```

Disable ryuk

```bash
export TESTCONTAINERS_RYUK_DISABLED="true"
```

Resource I used for learning

- https://blog.jetbrains.com/idea/2025/05/building-cloud-ready-apps-locally-spring-boot-aws-and-localstack-in-action/
- https://awspring.io/
- https://docs.awspring.io/spring-cloud-aws/docs/3.3.0/reference/html/index.html#getting-started