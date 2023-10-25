FROM debian:11

RUN apt-get update && apt-get upgrade -y && \
    apt-get install -y build-essential pkg-config python-dev python3-pip default-libmysqlclient-dev

RUN pip3 install --upgrade pip && \
    pip3 install flask-mysqldb mysql-connector-python

RUN mkdir -p /srv/templates
COPY /home/user/Downloads/index.html /srv/templates/
COPY /home/user/Downloads/app1.py /srv/

CMD ["flask", "run", "--host=0.0.0.0", "--app", "/srv/app1.py"]

