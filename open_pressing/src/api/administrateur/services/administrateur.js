'use strict';

/**
 * administrateur service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::administrateur.administrateur');
