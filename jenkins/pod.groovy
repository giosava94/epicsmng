def epicsmngPod(tag, body) {
  podTemplate(
    yaml: """
apiVersion: v1
kind: Pod
spec:
  imagePullSecrets:
    - name: baltig-reg-key
  containers:
    - name: builder
      image: baltig.infn.it:4567/epicscs/epicsmng:${tag}
      command:
        - cat
      tty: true
      resources:
        requests:
          cpu: "500m"
          memory: "128Mi"
        limits:
          cpu: "2"
          memory: "512Mi"
"""
  ) {
    body()
  }
}

return this