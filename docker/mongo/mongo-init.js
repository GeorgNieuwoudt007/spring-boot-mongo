db = db.getSiblingDB('mongo_db');

db.createUser({
    user: 'ADMIN',
    pwd: 'ADMIN',
    roles: [{
        role: 'readWrite',
        db: 'mongo_db'
    }]
});

db.createCollection('user');
